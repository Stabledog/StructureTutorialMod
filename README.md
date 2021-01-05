# Structure Tutorial Mod (Forge)
**How to register and generate structures in 1.16.3 Minecraft Forge using nbt files!**

**Change the Github branch to see previous MC versions of this tutorial.**
 
 ## NOTE: Jigsaw structures can spawn a single piece structure without any Jigsaw Blocks. I recommend using the Jigsaw branch on this github tutorial instead of non-Jigsaws.
 
 This very small Forge mod is full of comments that will help you understand what a lot of the methods do and what needs to be done to get your structure to generate. In all, this mod is really just 5 files plus 2 structure nbt files.  

If you don't know how to make a nbt file for structures, it's actually fairly simple and you can do it all inside minecraft itself! Here is a video on how to make and save a structure to nbt using structure blocks: 
>https://www.youtube.com/watch?v=ylGFb4F4xVk&t=1s 

Once saved, the structure nbt file is stored in that world's save folder within the generated folder inside. Grab those files as you'll need to put it under your mod's resource folder inside data.mod_id.structures. NOTICE: This the data folder and not the asset folder inside resource!
>![Image of the folder layout for Structure Tutorial Mod which shows the structure nbt files are inside data.structure_tutorial.structures which is inside src/main/resources](https://i.imgur.com/hNZoCql.png)

Now you're ready to begin adding the structure to your mod! Take a look at StructureTutorialMain, start reading the comments, and follow the methods/classes. Don't just copy the code quickly or else you will get confuse. Take your time and try to understand how it all works before attempting to register and generate your structure in your own mod.

When making your own mod, make sure to include the accesstransformer file and to include it in your build.gradle. If your IDE still say that the methods listed in the access transformer are private and shows an error, then you may need to refresh gradle and generate the runs again so the accesstransformers takes effect.

Good luck and I hope this helps!

**NOTE: Don't forget that Jigsaw Structures are a thing! They are more complex to setup but gives you more freedom and requires less code! See Vanilla's Pillager Outpost for an example Jigsaw Structure.**

------------------

_MCPBot is dead. Do not use that to check for updates._

_if you want the absolute latest mapping, run ` gradlew -PUPDATE_MAPPINGS="20200916-1.16.2" updateMappings `_

_command for the project and it'll remap everything to the cutting-edge mappings!_

_Otherwise, just use the mapping this mod uses for now:_

_mappings channel: 'snapshot', version: '20200916-1.16.2'_
 
