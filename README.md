# LeagueOfOOP
This project represents an implementation of a minimalist MMO game, in a 2D universe, implemented in Java having as objective the practical foundation of the builders and aggregation or inheritance, familiarization with Java and the basic concepts of POO, getting used to the SOLID principles and writing a code as generic as possible.

The reading and writing from and to the file are done with the help of the GameInputLoader class, where I used as a template the previous theme skeleton. Heroes are built using HeroFactory based on information from GameInput.

The Main class is used to instantiate the classes that do the writing and reading but also to instantiate the GameLogic class and start the game. The logic of the game is developed in the GameLogic class, where it is checked if there are players on the same position on the map and if yes then they attack and apply their skills to each other according to the rules set out in the project statement.

All heroes inherit the Hero class which has methods common to all 4 types of heroes such as: life throwers, xp, reset level and life methods, overtime damage setting etc. Classes with the name of the type of player contain only methods specific to that type. All the modifiers and constants are in the commons package.

In this version of the theme we did not implement double-dispatch.

For an explicit description of the methods and their understanding, check javadoc.
