// !LANGUAGE: +NewInference
// !DIAGNOSTICS: -UNREACHABLE_CODE -IMPLICIT_CAST_TO_ANY -UNUSED_VARIABLE -ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE -UNUSED_VALUE -UNUSED_PARAMETER -UNUSED_EXPRESSION
// SKIP_TXT

fun throwExc(b: Boolean): Boolean {
    if (b) throw Exception()
    else return false
}

// TESTCASE NUMBER: 1
fun case1() {
    val x1 = if (throwExc(false)) true
}


// TESTCASE NUMBER: 3
fun case3() {
    val x1 = if (throwExc(true)) true
}

/*
 * TESTCASE NUMBER: 4
 * UNEXPECTED BEHAVIOUR
 * ISSUES: KT-35510
 */
fun case4() {
    val x1 = if (throw Exception()) true

    val x2 = if (TODO()) true

    val x0 = if (false) true else if (throw Exception()) ;

}

// TESTCASE NUMBER: 5
fun case5() {
    var flag: Boolean? = null
    val x1 = if (flag ?: throw Exception()) true
}

/*
 * TESTCASE NUMBER: 6
 * UNEXPECTED BEHAVIOUR
 * ISSUES: KT-35510
 */
fun case6() {
    val k1 = if(throw Exception());
}

/*
 * TESTCASE NUMBER: 7
 * UNEXPECTED BEHAVIOUR
 * ISSUES: KT-35510
 */
fun case7(nothing: Nothing) {
    val k1 = if(throw Exception())
<!SYNTAX!><!>}

/*
 * TESTCASE NUMBER: 8
 * UNEXPECTED BEHAVIOUR
 * ISSUES: KT-35510
 */
fun case8(nothing: Nothing) {
    val x1 = if (nothing) true
}

/*
 * TESTCASE NUMBER: 9
 * UNEXPECTED BEHAVIOUR
 * ISSUES: KT-35510
 */fun case9() {
    val k1 = if(throw Exception())
<!SYNTAX!><!>}