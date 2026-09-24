// SPDX-FileCopyrightText: 2024-present MTS PJSC
// SPDX-License-Identifier: Apache-2.0
package io.github.mtsongithub.doetl.sparkdialectextensions.clickhouse.spark35

import io.github.mtsongithub.doetl.sparkdialectextensions.clickhouse.ClickhouseDialectBase

/**
 * ClickHouse dialect for Spark 3.5.x. All behaviour is inherited from [[ClickhouseDialectBase]];
 * Spark 3.5 needs no version-specific overrides.
 */
private object ClickhouseDialectExtension extends ClickhouseDialectBase
