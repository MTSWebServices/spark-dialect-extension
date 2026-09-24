// SPDX-FileCopyrightText: 2024-present MTS PJSC
// SPDX-License-Identifier: Apache-2.0
package io.github.mtsongithub.doetl.sparkdialectextensions.clickhouse.spark41

import io.github.mtsongithub.doetl.sparkdialectextensions.clickhouse.ClickhouseDialectBase
import java.sql.SQLException

/**
 * ClickHouse dialect for Spark 4.x. Shares all type-mapping logic with [[ClickhouseDialectBase]]
 * and only adds the Spark-4 `isObjectNotFoundException` hook.
 *
 * Compiled against Spark 4.1.x (the version that introduced `isObjectNotFoundException`). The
 * same artifact still runs on Spark 4.0.x: there `JdbcUtils.tableExists` uses the older `Try {
 * probe }.isSuccess` logic and never calls this method, so it is simply inert.
 */
private object ClickhouseDialectExtension extends ClickhouseDialectBase {

  /**
   * Spark 4.1 introduced `isObjectNotFoundException`, used by `JdbcUtils.tableExists` to tell a
   * missing table apart from a real error while probing with `SELECT 1 FROM t WHERE 1=0`. Without
   * this override every write to a not-yet-existing table fails, because the ClickHouse JDBC
   * driver does not report the `42*` SQLState the default implementation looks for.
   *
   * ClickHouse raises error code 60 (`UNKNOWN_TABLE`) for a missing table. Both driver lines in
   * use propagate the server error code into the `SQLException` vendor code
   * (`SQLException.getErrorCode`): 0.7.x via `com.clickhouse.jdbc.SqlExceptionUtils` and the
   * 0.9.x JDBC-v2 driver via `com.clickhouse.jdbc.internal.ExceptionUtils`. Matching on the
   * numeric code keeps this independent of the server locale, unlike matching on the message
   * text.
   */
  override def isObjectNotFoundException(e: SQLException): Boolean = {
    val UNKNOWN_TABLE = 60
    e.getErrorCode == UNKNOWN_TABLE
  }
}
