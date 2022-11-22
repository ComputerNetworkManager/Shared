package me.cnm.shared.xjkl.extention

fun Array<out String>.contains(needle: String, ignoreCase: Boolean = true): Boolean =
    this.any { it.equals(needle, ignoreCase) }

fun Array<out String>.contains(needle: Array<String>, ignoreCase: Boolean = true): Boolean =
    needle.any { this.contains(it, ignoreCase) }

fun String.inArray(haystack: Array<out String>, ignoreCase: Boolean = true) = haystack.contains(this, ignoreCase)