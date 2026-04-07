## Data Type Mappings for Spark Dialect Extension

This documentation outlines the customized mappings that the Spark Dialect Extension implements that optimize interactions between Spark and ClickHouse.

There is the possibility to use Nullable types.

#### Customized Type Mappings with Spark Dialect Extension

Primitive types:

| ClickHouse Type (Read) | Spark Type           | ClickHouse Type (Write) | ClickHouse Type (Create)                             |
|------------------------|----------------------|-------------------------|------------------------------------------------------|
| `Bool`                 | `BooleanType`        | `Bool`                  | `Bool (Spark's default is UInt64)`                   |
| `Int8`                 | `ByteType`           | `Int8`                  | `Int8 (Spark's default is Int32)`                    |
| `Int16`                | `ShortType`          | `Int16`                 | `Int16 (Spark's default is Int32)`                   |
| `Int32`                | `IntegerType`        | `Int32`                 | `Int32`                                              |
| `Int64`                | `LongType`           | `Int64`                 | `Int64`                                              |
| `UInt8`                | `ShortType`          | `UInt8`                 | `UInt8`                                              |
| `UInt16`               | `IntegerType`        | `UInt16`                | `UInt16`                                             |
| `UInt32`               | `LongType`           | `Int64`                 | `Int64 (Spark's default is Decimal(20, 0))`          |
| `UInt64`               | `DecimalType(38, 0)` | `Decimal(38, 0)`        | `Decimal(38, 0) (Spark's default is Decimal(20, 0))` |
| `Float32`              | `FloatType`          | `Float32`               | `Float32`                                            |
| `Float64`              | `DoubleType`         | `Float64`               | `Float64`                                            |
| `Decimal(M, N)`        | `DecimalType(M, N)`  | `Decimal(M, N)`         | `Decimal(M, N)`                                      |
| `Decimal32(N)`         | `DecimalType(9, N)`  | `Decimal(9, N)`         | `Decimal(9, N)`                                      |
| `Decimal64(N)`         | `DecimalType(18, N)` | `Decimal(18, N)`        | `Decimal(18, N)`                                     |
| `Decimal128(N)`        | `DecimalType(38, N)` | `Decimal(38, N)`        | `Decimal(38, N)`                                     |
| `Decimal256(N)`        | unsupported          | unsupported             | unsupported                                          |
| `Date`                 | `DateType`           | `Date`                  | `Date`                                               |
| `DateTime`             | `TimestampType`      | `DateTime`              | `DateTime`                                           |
| `DateTime64(6)`        | `TimestampType`      | `DateTime64(6)`         | `DateTime64(6) (Spark's default is DateTime32)`      |


``Array(T)`` `->` ``ArrayType(T)`` (without this extension Spark does not support Arrays for GenericJDBC dialect):

| ClickHouse Type (Read)                       | Spark Type                       | ClickHouse Type (Write) | ClickHouse Type (Create) |
|----------------------------------------------|----------------------------------|-------------------------|--------------------------|
| `Array(String)`                              | `ArrayType(StringType)`          | `Array(String)`         | `Array(String)`          |
| `Array(Int8) (Only 0.9.2+)`                  | `ArrayType(ByteType)`            | `Array(Int8)`           | `Array(Int8)`            |
| `Array(Int16) (Only 0.9.2+)`                 | `ArrayType(ShortType)`           | `Array(Int16)`          | `Array(Int16)`           |
| `Array(Int32) (Only 0.9.2+)`                 | `ArrayType(IntegerType)`         | `Array(Int32)`          | `Array(Int32)`           |
| `Array(Int64) (Only 0.9.2+)`                 | `ArrayType(LongType)`            | `Array(Int64)`          | `Array(Int64)`           |
| `Array(UInt8) (Only 0.9.2+)`                 | `ArrayType(ShortType)`           | `Array(UInt8)`          | `Array(UInt8)`           |
| `Array(UInt16) (Only 0.9.2+)`                | `ArrayType(IntegerType)`         | `Array(UInt16)`         | `Array(UInt16)`          |
| `Array(UInt32) (Only 0.9.2+)`                | `ArrayType(LongType)`            | `Array(Int64)`          | `Array(Int64)`           |
| `Array(UInt64)`                              | unsupported                      |                         |                          |
| `Array(Decimal(M, N))`                       | `ArrayType(DecimalType(M, N))`   | `Array(Decimal(M, N))`  | `Array(Decimal(M, N))`   |
| `Array(Float32) (Only 0.9.5+)`               | `ArrayType(FloatType)`           | `Array(Float32)`        | `Array(Float32)`         |
| `Array(Float64) (Only 0.9.2+)`               | `ArrayType(DoubleType)`          | `Array(Float64)`        | `Array(Float64)`         |
| `Array(DateType) (Only 0.9.5+)`              | `ArrayType(Date)`                | `Array(Date)`           | `Array(Date)`            |
| `Array(TimestampType) (Only 0.9.5+)`         | `ArrayType(TimestampType)`       | `Array(DateTime64(6))`  | `Array(DateTime64(6))`   |
