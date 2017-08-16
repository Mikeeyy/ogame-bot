package com.matejko.service.impl;

import com.matejko.service.interfaces.EncryptionService;

import javax.inject.Named;
import java.util.Base64;

/**
 * Created by Mikołaj Matejko on 01.08.2017 as part of ogame-expander
 */
@Named
public class EncryptionServiceImpl implements EncryptionService {

    @Override
    public String encrypt(String word) {
        return new String(Base64.getEncoder().encode(word.getBytes()));
    }

    @Override
    public String decrypt(String word) {
        return new String(Base64.getDecoder().decode(word));
    }
}
