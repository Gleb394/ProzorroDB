package com.prozorro.service;

import com.prozorro.Model.Tender;
import com.prozorro.repositotory.TenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplTenderService implements TenderService {

    @Autowired
    private TenderRepository tenderRepository;

    @Override
    public Tender save(Tender tender) {
        return tenderRepository.save(tender);
    }

    @Override
    public Iterable<Tender> save(List<Tender> tenders) {
        return tenderRepository.saveAll(tenders);
    }
}
