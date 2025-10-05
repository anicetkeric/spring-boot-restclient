package com.bootlabs.demo.dto;

public record Product(
        Long id,
        String title,
        String description,
        Double price,
        String category,
        String image
) {}
