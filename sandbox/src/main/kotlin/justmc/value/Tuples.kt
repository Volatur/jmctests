package justmc.value

import justmc.annotation.*

@Tuple data class Tuple2<A, B>(val a: A, val b: B)
@Tuple data class Tuple3<A, B, C>(val a: A, val b: B, val c: C)
@Tuple data class Tuple4<A, B, C, D>(val a: A, val b: B, val c: C, val d: D)
@Tuple data class Tuple5<A, B, C, D, E>(val a: A, val b: B, val c: C, val d: D, val e: E)
@Tuple data class Tuple6<A, B, C, D, E, F>(val a: A, val b: B, val c: C, val d: D, val e: E, val f: F)
@Tuple data class Tuple7<A, B, C, D, E, F, G>(val a: A, val b: B, val c: C, val d: D, val e: E, val f: F, val g: G)
