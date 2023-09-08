package com.capacitaciones.continuas.uploads.constants;

import java.util.HashMap;
import java.util.Map;

public class ConstantsNames {
    public static final String PATH_ROOT = "uploads";
    public static final String DOCUMENTS_EXEL = "uploads/documents";
    public static final String DOCUMENTS_HOJA_VIDA = "uploads/documents_pdfs";
    public static final String IMAGE_COURSE = "uploads/images_course";
    public static final String IMAGE_USER = "uploads/images_user";


    public static final Map<String, String> FOLDER_MAPPING = new HashMap<>();
    static {
        FOLDER_MAPPING.put("documents", DOCUMENTS_EXEL);
        FOLDER_MAPPING.put("documents_pdfs", DOCUMENTS_HOJA_VIDA);
        FOLDER_MAPPING.put("images_course", IMAGE_COURSE);
        FOLDER_MAPPING.put("images_user", IMAGE_USER);
    }
}
