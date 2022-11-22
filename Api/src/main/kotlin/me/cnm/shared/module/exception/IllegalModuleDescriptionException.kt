package me.cnm.shared.module.exception

/**
 * Exception thrown when the module.json of a module is not correct
 *
 * @constructor Create the exception
 * @param module     The module witch's module.json isn't correct
 * @param field      The field of the module.json witch isn't correct
 * @param type       The type, why it isn't correct
 * @param additional An additional context
 */
class IllegalModuleDescriptionException(
    module: String,
    field: String,
    type: Type,
    additional: String? = null
) : RuntimeException("The module.json of " + module + " isn't correct: " + type.getMessage(field, additional)) {

    /**
     * Enum with types, why a module.json could be illegal
     */
    enum class Type {

        /**
         * The field is required but not present
         */
        REQUIRED {
            override fun getMessage(field: String, additional: String?): String {
                return "$field is required"
            }
        },

        /**
         * The field is from the wrong type
         */
        WRONG_TYPE {
            override fun getMessage(field: String, additional: String?): String {
                return "$field needs to be from type $additional"
            }
        },

        /**
         * The field is from the correct type, but has wrong content (e.g. alphanumeric)
         */
        WRONG_CONTENT {
            override fun getMessage(field: String, additional: String?): String {
                return "$field needs be $additional"
            }
        };

        /**
         * Get the message witch should be shown in the exception message
         *
         * @param field      The field which is wrong
         * @param additional The additional context
         * @return The message to be shown
         */
        abstract fun getMessage(field: String, additional: String?): String
    }
}
