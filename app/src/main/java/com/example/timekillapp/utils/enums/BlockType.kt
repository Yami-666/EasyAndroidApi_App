package com.example.timekillapp.utils.enums

enum class BlockType {
    SELF_LOCK,
    LOCK,
    UNLOCK,
    BROKEN;

    companion object {
        infix fun from(blockTypeNumber: String): BlockType? {
            return when(blockTypeNumber) {
                "0" -> SELF_LOCK
                "1" -> LOCK
                "2" -> UNLOCK
                "3" -> BROKEN
                else -> null
            }
        }
    }
}
