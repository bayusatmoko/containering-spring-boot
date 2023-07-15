package com.example.ec.exploremsboot.service;

import com.example.ec.exploremsboot.domain.TourPackage;
import com.example.ec.exploremsboot.repo.TourPackageRepository;
import org.springframework.stereotype.Service;

@Service
public class TourPackageService {
    private final TourPackageRepository tourPackageRepository;

    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    public TourPackage createTourPackage(String code, String name) {

        return tourPackageRepository.findById(code)
                .orElse(tourPackageRepository.save(new TourPackage(code, name)));
    }

    public Iterable<TourPackage> lookup() {

        return tourPackageRepository.findAll();
    }

    public long total() {

        return tourPackageRepository.count();
    }
}
