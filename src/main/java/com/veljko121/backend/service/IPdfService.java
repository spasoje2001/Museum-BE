package com.veljko121.backend.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import com.itextpdf.text.DocumentException;



public interface IPdfService {
    ByteArrayInputStream generateOrganizerExhibitionReport(Integer organizerId) throws DocumentException, IOException;
    ByteArrayInputStream generateCuratorExhibitionReport(Integer curatorId) throws DocumentException, IOException;

}
