package com.veljko121.backend.controller.tours;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tours")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ORGANIZER')")
public class TourPricelistController {

}
