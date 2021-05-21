package com.fiap.financiamento.service.impl;

import com.fiap.financiamento.dto.Intent;
import com.fiap.financiamento.entity.IntentEntity;
import com.fiap.financiamento.repository.IntentRepository;
import com.fiap.financiamento.service.IntentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntentServiceImpl implements IntentService {

    @Autowired
    private IntentRepository repository;

    @Override
    public List<Intent> intentList() {
        List<IntentEntity> list = repository.findAll();

        List<Intent> intents = fromTo(list);
        return intents;

    }

    @Override
    public Intent intentSave(Intent intent) {
        IntentEntity entity = fromTo(intent);
        entity = repository.save(entity);
        Intent intentReturn = fromTo(entity);
        return intentReturn;
    }

    @Override
    public Intent editIntent(Long id) {
        IntentEntity entity = repository.findById(id).get();
        return fromTo(entity);
    }

    @Override
    public void deleteIntent(Long id) {
        repository.deleteById(id);

    }

    private List<Intent> fromTo(List<IntentEntity> list){
        List<Intent> listDto = new ArrayList<>();
        for (IntentEntity intentEntity : list) {
            Intent dto = new Intent();
            dto.setId(intentEntity.getId());
            dto.setName(intentEntity.getName());
            dto.setAdress(intentEntity.getAdress());
            dto.setContact(intentEntity.getContact());
            dto.setSocialNumber(intentEntity.getSocialNumber());
            dto.setGeneralNumber(intentEntity.getGeneralNumber());
            dto.setBirthDate(intentEntity.getBirthDate());
            dto.setCategory(intentEntity.getCategory());
            dto.setIntentValue(intentEntity.getIntentValue());
            dto.setQuantity(intentEntity.getQuantity());
            listDto.add(dto);
        }
        return listDto;
    }

    private IntentEntity fromTo(Intent intent){
        IntentEntity entity =  new IntentEntity();

        entity.setId(intent.getId());
        entity.setName(intent.getName());
        entity.setAdress(intent.getAdress());
        entity.setContact(intent.getContact());
        entity.setSocialNumber(intent.getSocialNumber());
        entity.setGeneralNumber(intent.getGeneralNumber());
        entity.setBirthDate(intent.getBirthDate());
        entity.setCategory(intent.getCategory());
        entity.setIntentValue(intent.getIntentValue());
        entity.setQuantity(intent.getQuantity());

        return entity;
    }

    private Intent fromTo(IntentEntity entity){
        Intent intent =  new Intent();

        intent.setId(entity.getId());
        intent.setName(entity.getName());
        intent.setAdress(entity.getAdress());
        intent.setContact(entity.getContact());
        intent.setSocialNumber(entity.getSocialNumber());
        intent.setGeneralNumber(entity.getGeneralNumber());
        intent.setBirthDate(entity.getBirthDate());
        intent.setCategory(entity.getCategory());
        intent.setIntentValue(entity.getIntentValue());
        intent.setQuantity(entity.getQuantity());

        return intent;
    }
}
