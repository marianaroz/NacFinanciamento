package com.fiap.financiamento.service;

import java.util.List;

import com.fiap.financiamento.dto.Intent;

public interface IntentService {

    List<Intent> intentList();
    Intent intentSave(Intent intent);
    Intent editIntent(Long id);
    void deleteIntent(Long id);
}

