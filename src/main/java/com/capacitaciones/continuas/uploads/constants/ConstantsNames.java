package com.capacitaciones.continuas.uploads.constants;

import java.util.HashMap;
import java.util.Map;

public class ConstantsNames {
    public static final String PATH_ROOT = "uploads";
    public static final String DOCUMENTS_EXEL = "uploads/documents";
    public static final String IMAGE_COURSE = "uploads/image";

    public static final Map<String, String> FOLDER_MAPPING = new HashMap<>();
    static {
        FOLDER_MAPPING.put("documents", DOCUMENTS_EXEL);
        FOLDER_MAPPING.put("images", IMAGE_COURSE);
    }
}
