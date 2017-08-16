# ogame-bot

Simple OGame bot, entering browser once per some fixed time, detecting materials/buildings/techs and creating new ones based on strategy.

# Instruction:

### 1. Add new user using REST.
Resource: **/job/users**
Payload:
```
[
  {
    "username": "abc",
    "password": "xxxxx",
    "universum": "s142-pl.ogame.gameforge.com"
  }
]
```

### 2. Set new timer using REST.
Resource: **/job/settings**
Payload:
```
[
  {
     "timer":"NEXT_JOB",
     "active":"true",
     "interval":900000
  }
]
```

### 3. Set auto-expanding strategy for user using REST.
Resource: **/job/auto**
Payload:
```
[ 
  {
    "user": {
      "username": "XXXX"
    },
    "strategy": "QUICK_START",
    "active": "true"
  }
]
```

That's all. Now every specified interval the strategy will be executed.
You can also manually execute strategy by invoking REST:
Resource: **/job/next**
Payload:
```
[ 
  {
    "user": {
      "username": "XXXX"
    },
    "strategy": "QUICK_START"
  }
]
```
