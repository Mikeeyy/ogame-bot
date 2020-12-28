package com.matejko.model.standard;

import lombok.Value;

/**
 * Created by Mikołaj Matejko on 01.08.2017 as part of ogame-expander
 */
@Value
public class DecryptedUser {
	String username;
	String password;
	String universum;
}
