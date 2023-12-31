package com.example.ec.exploremsboot.service;

import com.example.ec.exploremsboot.domain.Difficulty;
import com.example.ec.exploremsboot.domain.Region;
import com.example.ec.exploremsboot.domain.Tour;
import com.example.ec.exploremsboot.domain.TourPackage;
import com.example.ec.exploremsboot.repo.TourPackageRepository;
import com.example.ec.exploremsboot.repo.TourRepository;
import org.springframework.stereotype.Service;

@Service
public class TourService {

    private final TourRepository tourRepository;
    private final TourPackageRepository tourPackageRepository;

    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createTour(String title, String description, String blurb, Integer price, String duration, String bullets,
                           String keywords, String tourPackageName, Difficulty difficulty, Region region) {
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName)
                .orElseThrow(() -> new RuntimeException("Tour package does not exists " + tourPackageName));

        return tourRepository.save(new Tour(title, description, blurb, price, duration, bullets, keywords, tourPackage, difficulty, region));
    }

    public long total() {
        return tourRepository.count();
    }
}
