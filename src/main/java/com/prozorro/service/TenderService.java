package com.prozorro.service;

import com.prozorro.Model.Tender;

import java.util.List;

public interface TenderService {

    Tender save(Tender tender);

    Iterable<Tender> save(List<Tender> tenders);
}
