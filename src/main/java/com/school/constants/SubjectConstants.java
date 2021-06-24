package com.school.constants;

public class SubjectConstants {

    // Validation rules
    public static final String SUBJECT_NAME_VALIDATION_REGEX = "[a-zA-Z\\s]{1,50}";

    // Error messages
    public static final String SUBJECT_NAME_ONLY_LETTERS_ERROR_MESSAGE  =
            "Subject name must contain only letters and length must be up to 50 letters";
    public static final String SUBJECT_NAME_EXISTS_ERROR_MESSAGE  =
            "Subject with such name already exists";
    public static final String DUPLICATE_NAME_ERROR_MESSAGE  =
            "There are subjects with the same name";
    public static final String SUBJECT_ID_MISSING_ERROR_MESSAGE  =
            "Unable to find subject Id";
    public static final String UNABLE_TO_UPDATE_SUBJECT_ERROR_MESSAGE  =
            "Unable to find subject Id";

    // Error codes
    public static final int SUBJECT_NAME_ONLY_LETTERS_ERROR_CODE = 1000;
    public static final int DUPLICATE_NAME_ERROR_CODE = 1001;
    public static final int SUBJECT_ID_MISSING_ERROR_CODE = 1002;
    public static final int UNABLE_TO_UPDATE_SUBJECT_ERROR_CODE = 1003;
}
