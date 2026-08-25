execute at @e[type=arrow,nbt={weapon:{id:"morebows:basalt_bow"}, inGround:0b}] run particle minecraft:flame ~ ~ ~ 0.05 0.05 0.05 0 2
execute at @e[type=arrow,nbt={weapon:{id:"morebows:super_bow"}, inGround:0b}] run particle minecraft:flame ~ ~ ~ 0.05 0.05 0.05 0 2
execute at @e[type=arrow,nbt={weapon:{id:"morebows:spider_bow"}, inGround:1b}] run setblock ~ ~ ~ minecraft:cobweb
execute at @e[type=arrow,nbt={weapon:{id:"morebows:super_bow"}, inGround:1b}] run setblock ~ ~ ~ minecraft:cobweb
kill @e[type=arrow,nbt={weapon:{id:"morebows:spider_bow"}, inGround:1b}]
kill @e[type=arrow,nbt={weapon:{id:"morebows:super_bow"}, inGround:1b}]