package com.veljko121.backend.core.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum ExhibitionTheme {
    ANCIENT_HISTORY,
    MEDIEVAL_HISTORY,
    MODERN_HISTORY,
    FINE_ARTS,
    CONTEMPORARY_ART,
    PHOTOGRAPHY,
    SCULPTURE,
    SCIENCE_AND_TECHNOLOGY,
    NATURAL_HISTORY,
    MARITIME,
    AVIATION,
    SPACE_EXPLORATION,
    WORLD_CULTURES,
    INDIGENOUS_CULTURES,
    MUSIC_HISTORY,
    LITERARY_ARTS,
    FASHION_AND_DESIGN,
    FILM_AND_MEDIA,
    ARCHAEOLOGY,
    MILITARY_HISTORY,
    ENVIRONMENTAL_SCIENCE,
    CHILDREN_EDUCATION,
    SEASONAL;

    public static String getDisplayName(ExhibitionTheme theme) {
        String name = theme.name().toLowerCase().replace('_', ' ');
        return Arrays.stream(name.split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                .collect(Collectors.joining(" "));
    }
}
