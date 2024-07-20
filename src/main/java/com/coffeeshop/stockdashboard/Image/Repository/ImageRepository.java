package com.coffeeshop.stockdashboard.Image.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeeshop.stockdashboard.Image.Entity.Image;

public interface ImageRepository extends JpaRepository<Image, Integer>{}
