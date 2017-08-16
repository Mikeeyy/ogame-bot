package com.matejko.service.interfaces;

/**
 * Created by Mikołaj Matejko on 01.08.2017 as part of ogame-expander
 */
public interface EncryptionService {
    String encrypt(String word);

    String decrypt(String word);
}
