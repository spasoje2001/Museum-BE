package com.veljko121.backend.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import com.itextpdf.text.DocumentException;



public interface IPdfService {
    ByteArrayInputStream generateCleansedItemsPdf(Integer requestedBy) throws DocumentException, IOException;
    void saveCleansedItemsPdf(Integer requestedBy) throws DocumentException, IOException;
} 
