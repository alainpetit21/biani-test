package com.bianisoft.tests.javatestapp;


//LWJGL library imports
import org.lwjgl.util.Rectangle;

//Bianisoft imports
import com.bianisoft.engine.Context;
import com.bianisoft.engine.backgrounds.Background;
import com.bianisoft.engine.labels.Label;
import com.bianisoft.engine.sprites.Sprite;
import com.bianisoft.engine.sprites.Sprite.State;
import com.bianisoft.engine.sprites.Button;


public class DesignCtxMyContext7{
	public static void load(Context p_ctxUnder){
		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:0|Sprite|Spr_Test1|/res/sprites/SprHero.png|12|-230|0|1|0|1|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_Test1= new Sprite("/res/sprites/SprHero.png");
		sprSpr_Test1.setTextID("Spr_Test1");
		sprSpr_Test1.setPos(12, -230, 0);
		sprSpr_Test1.addState(sprSpr_Test1.new State("StateName0", 8, 0.09375f));
		sprSpr_Test1.addState(sprSpr_Test1.new State("StateName1", 8, 0.09375f));
		sprSpr_Test1.addState(sprSpr_Test1.new State("StateName2", 8, 0.09375f));
		sprSpr_Test1.addState(sprSpr_Test1.new State("StateName3", 8, 0.09375f));
		sprSpr_Test1.addState(sprSpr_Test1.new State("StateName4", 8, 0.09375f));
		sprSpr_Test1.addState(sprSpr_Test1.new State("StateName5", 8, 0.09375f));
		sprSpr_Test1.addState(sprSpr_Test1.new State("StateName6", 8, 0.09375f));
		sprSpr_Test1.addState(sprSpr_Test1.new State("StateName7", 8, 0.09375f));
		sprSpr_Test1.load();
		sprSpr_Test1.setCurState(0);
		sprSpr_Test1.setCurFrame(1);
		p_ctxUnder.addChild(sprSpr_Test1, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:1|Sprite|Spr_Cursor|/res/sprites/Cursor.png|85|82|0|1|0|0|2|StateName0|1|0.0|StateName1|1|0.0|*/
		Sprite sprSpr_Cursor= new Sprite("/res/sprites/Cursor.png");
		sprSpr_Cursor.setTextID("Spr_Cursor");
		sprSpr_Cursor.setPos(85, 82, 0);
		sprSpr_Cursor.addState(sprSpr_Cursor.new State("StateName0", 1, 0.0f));
		sprSpr_Cursor.addState(sprSpr_Cursor.new State("StateName1", 1, 0.0f));
		sprSpr_Cursor.load();
		sprSpr_Cursor.setCurState(0);
		sprSpr_Cursor.setCurFrame(0);
		p_ctxUnder.addChild(sprSpr_Cursor, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:2|Sprite|Spr_Test2|/res/sprites/SprHero.png|0|-54|0|1|0|4|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_Test2= new Sprite("/res/sprites/SprHero.png");
		sprSpr_Test2.setTextID("Spr_Test2");
		sprSpr_Test2.setPos(0, -54, 0);
		sprSpr_Test2.addState(sprSpr_Test2.new State("StateName0", 8, 0.09375f));
		sprSpr_Test2.addState(sprSpr_Test2.new State("StateName1", 8, 0.09375f));
		sprSpr_Test2.addState(sprSpr_Test2.new State("StateName2", 8, 0.09375f));
		sprSpr_Test2.addState(sprSpr_Test2.new State("StateName3", 8, 0.09375f));
		sprSpr_Test2.addState(sprSpr_Test2.new State("StateName4", 8, 0.09375f));
		sprSpr_Test2.addState(sprSpr_Test2.new State("StateName5", 8, 0.09375f));
		sprSpr_Test2.addState(sprSpr_Test2.new State("StateName6", 8, 0.09375f));
		sprSpr_Test2.addState(sprSpr_Test2.new State("StateName7", 8, 0.09375f));
		sprSpr_Test2.load();
		sprSpr_Test2.setCurState(0);
		sprSpr_Test2.setCurFrame(4);
		p_ctxUnder.addChild(sprSpr_Test2, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:3|Sprite|Spr_Test3|/res/sprites/SprHero.png|9|-186|0|1|0|1|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_Test3= new Sprite("/res/sprites/SprHero.png");
		sprSpr_Test3.setTextID("Spr_Test3");
		sprSpr_Test3.setPos(9, -186, 0);
		sprSpr_Test3.addState(sprSpr_Test3.new State("StateName0", 8, 0.09375f));
		sprSpr_Test3.addState(sprSpr_Test3.new State("StateName1", 8, 0.09375f));
		sprSpr_Test3.addState(sprSpr_Test3.new State("StateName2", 8, 0.09375f));
		sprSpr_Test3.addState(sprSpr_Test3.new State("StateName3", 8, 0.09375f));
		sprSpr_Test3.addState(sprSpr_Test3.new State("StateName4", 8, 0.09375f));
		sprSpr_Test3.addState(sprSpr_Test3.new State("StateName5", 8, 0.09375f));
		sprSpr_Test3.addState(sprSpr_Test3.new State("StateName6", 8, 0.09375f));
		sprSpr_Test3.addState(sprSpr_Test3.new State("StateName7", 8, 0.09375f));
		sprSpr_Test3.load();
		sprSpr_Test3.setCurState(0);
		sprSpr_Test3.setCurFrame(1);
		p_ctxUnder.addChild(sprSpr_Test3, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:4|Sprite|Spr_Test4|/res/sprites/SprHero.png|4|-101|0|1|0|4|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_Test4= new Sprite("/res/sprites/SprHero.png");
		sprSpr_Test4.setTextID("Spr_Test4");
		sprSpr_Test4.setPos(4, -101, 0);
		sprSpr_Test4.addState(sprSpr_Test4.new State("StateName0", 8, 0.09375f));
		sprSpr_Test4.addState(sprSpr_Test4.new State("StateName1", 8, 0.09375f));
		sprSpr_Test4.addState(sprSpr_Test4.new State("StateName2", 8, 0.09375f));
		sprSpr_Test4.addState(sprSpr_Test4.new State("StateName3", 8, 0.09375f));
		sprSpr_Test4.addState(sprSpr_Test4.new State("StateName4", 8, 0.09375f));
		sprSpr_Test4.addState(sprSpr_Test4.new State("StateName5", 8, 0.09375f));
		sprSpr_Test4.addState(sprSpr_Test4.new State("StateName6", 8, 0.09375f));
		sprSpr_Test4.addState(sprSpr_Test4.new State("StateName7", 8, 0.09375f));
		sprSpr_Test4.load();
		sprSpr_Test4.setCurState(0);
		sprSpr_Test4.setCurFrame(4);
		p_ctxUnder.addChild(sprSpr_Test4, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:5|Sprite|Spr_Test5|/res/sprites/SprHero.png|2|31|0|1|0|4|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_Test5= new Sprite("/res/sprites/SprHero.png");
		sprSpr_Test5.setTextID("Spr_Test5");
		sprSpr_Test5.setPos(2, 31, 0);
		sprSpr_Test5.addState(sprSpr_Test5.new State("StateName0", 8, 0.09375f));
		sprSpr_Test5.addState(sprSpr_Test5.new State("StateName1", 8, 0.09375f));
		sprSpr_Test5.addState(sprSpr_Test5.new State("StateName2", 8, 0.09375f));
		sprSpr_Test5.addState(sprSpr_Test5.new State("StateName3", 8, 0.09375f));
		sprSpr_Test5.addState(sprSpr_Test5.new State("StateName4", 8, 0.09375f));
		sprSpr_Test5.addState(sprSpr_Test5.new State("StateName5", 8, 0.09375f));
		sprSpr_Test5.addState(sprSpr_Test5.new State("StateName6", 8, 0.09375f));
		sprSpr_Test5.addState(sprSpr_Test5.new State("StateName7", 8, 0.09375f));
		sprSpr_Test5.load();
		sprSpr_Test5.setCurState(0);
		sprSpr_Test5.setCurFrame(4);
		p_ctxUnder.addChild(sprSpr_Test5, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:6|Sprite|Spr_Test6|/res/sprites/SprHero.png|7|-147|0|1|0|6|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_Test6= new Sprite("/res/sprites/SprHero.png");
		sprSpr_Test6.setTextID("Spr_Test6");
		sprSpr_Test6.setPos(7, -147, 0);
		sprSpr_Test6.addState(sprSpr_Test6.new State("StateName0", 8, 0.09375f));
		sprSpr_Test6.addState(sprSpr_Test6.new State("StateName1", 8, 0.09375f));
		sprSpr_Test6.addState(sprSpr_Test6.new State("StateName2", 8, 0.09375f));
		sprSpr_Test6.addState(sprSpr_Test6.new State("StateName3", 8, 0.09375f));
		sprSpr_Test6.addState(sprSpr_Test6.new State("StateName4", 8, 0.09375f));
		sprSpr_Test6.addState(sprSpr_Test6.new State("StateName5", 8, 0.09375f));
		sprSpr_Test6.addState(sprSpr_Test6.new State("StateName6", 8, 0.09375f));
		sprSpr_Test6.addState(sprSpr_Test6.new State("StateName7", 8, 0.09375f));
		sprSpr_Test6.load();
		sprSpr_Test6.setCurState(0);
		sprSpr_Test6.setCurFrame(6);
		p_ctxUnder.addChild(sprSpr_Test6, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:7|Sprite|Spr_Test7|/res/sprites/SprHero.png|30|200|0|1|0|1|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_Test7= new Sprite("/res/sprites/SprHero.png");
		sprSpr_Test7.setTextID("Spr_Test7");
		sprSpr_Test7.setPos(30, 200, 0);
		sprSpr_Test7.addState(sprSpr_Test7.new State("StateName0", 8, 0.09375f));
		sprSpr_Test7.addState(sprSpr_Test7.new State("StateName1", 8, 0.09375f));
		sprSpr_Test7.addState(sprSpr_Test7.new State("StateName2", 8, 0.09375f));
		sprSpr_Test7.addState(sprSpr_Test7.new State("StateName3", 8, 0.09375f));
		sprSpr_Test7.addState(sprSpr_Test7.new State("StateName4", 8, 0.09375f));
		sprSpr_Test7.addState(sprSpr_Test7.new State("StateName5", 8, 0.09375f));
		sprSpr_Test7.addState(sprSpr_Test7.new State("StateName6", 8, 0.09375f));
		sprSpr_Test7.addState(sprSpr_Test7.new State("StateName7", 8, 0.09375f));
		sprSpr_Test7.load();
		sprSpr_Test7.setCurState(0);
		sprSpr_Test7.setCurFrame(1);
		p_ctxUnder.addChild(sprSpr_Test7, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:8|Sprite|Spr_Test8|/res/sprites/SprHero.png|2|73|0|1|0|1|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_Test8= new Sprite("/res/sprites/SprHero.png");
		sprSpr_Test8.setTextID("Spr_Test8");
		sprSpr_Test8.setPos(2, 73, 0);
		sprSpr_Test8.addState(sprSpr_Test8.new State("StateName0", 8, 0.09375f));
		sprSpr_Test8.addState(sprSpr_Test8.new State("StateName1", 8, 0.09375f));
		sprSpr_Test8.addState(sprSpr_Test8.new State("StateName2", 8, 0.09375f));
		sprSpr_Test8.addState(sprSpr_Test8.new State("StateName3", 8, 0.09375f));
		sprSpr_Test8.addState(sprSpr_Test8.new State("StateName4", 8, 0.09375f));
		sprSpr_Test8.addState(sprSpr_Test8.new State("StateName5", 8, 0.09375f));
		sprSpr_Test8.addState(sprSpr_Test8.new State("StateName6", 8, 0.09375f));
		sprSpr_Test8.addState(sprSpr_Test8.new State("StateName7", 8, 0.09375f));
		sprSpr_Test8.load();
		sprSpr_Test8.setCurState(0);
		sprSpr_Test8.setCurFrame(1);
		p_ctxUnder.addChild(sprSpr_Test8, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:9|Sprite|Spr_Test9|/res/sprites/SprHero.png|0|-10|0|1|0|1|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_Test9= new Sprite("/res/sprites/SprHero.png");
		sprSpr_Test9.setTextID("Spr_Test9");
		sprSpr_Test9.setPos(0, -10, 0);
		sprSpr_Test9.addState(sprSpr_Test9.new State("StateName0", 8, 0.09375f));
		sprSpr_Test9.addState(sprSpr_Test9.new State("StateName1", 8, 0.09375f));
		sprSpr_Test9.addState(sprSpr_Test9.new State("StateName2", 8, 0.09375f));
		sprSpr_Test9.addState(sprSpr_Test9.new State("StateName3", 8, 0.09375f));
		sprSpr_Test9.addState(sprSpr_Test9.new State("StateName4", 8, 0.09375f));
		sprSpr_Test9.addState(sprSpr_Test9.new State("StateName5", 8, 0.09375f));
		sprSpr_Test9.addState(sprSpr_Test9.new State("StateName6", 8, 0.09375f));
		sprSpr_Test9.addState(sprSpr_Test9.new State("StateName7", 8, 0.09375f));
		sprSpr_Test9.load();
		sprSpr_Test9.setCurState(0);
		sprSpr_Test9.setCurFrame(1);
		p_ctxUnder.addChild(sprSpr_Test9, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:10|Sprite|Spr_TestA|/res/sprites/SprHero.png|-1|118|0|1|0|1|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_TestA= new Sprite("/res/sprites/SprHero.png");
		sprSpr_TestA.setTextID("Spr_TestA");
		sprSpr_TestA.setPos(-1, 118, 0);
		sprSpr_TestA.addState(sprSpr_TestA.new State("StateName0", 8, 0.09375f));
		sprSpr_TestA.addState(sprSpr_TestA.new State("StateName1", 8, 0.09375f));
		sprSpr_TestA.addState(sprSpr_TestA.new State("StateName2", 8, 0.09375f));
		sprSpr_TestA.addState(sprSpr_TestA.new State("StateName3", 8, 0.09375f));
		sprSpr_TestA.addState(sprSpr_TestA.new State("StateName4", 8, 0.09375f));
		sprSpr_TestA.addState(sprSpr_TestA.new State("StateName5", 8, 0.09375f));
		sprSpr_TestA.addState(sprSpr_TestA.new State("StateName6", 8, 0.09375f));
		sprSpr_TestA.addState(sprSpr_TestA.new State("StateName7", 8, 0.09375f));
		sprSpr_TestA.load();
		sprSpr_TestA.setCurState(0);
		sprSpr_TestA.setCurFrame(1);
		p_ctxUnder.addChild(sprSpr_TestA, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:11|Sprite|Spr_TestB|/res/sprites/SprHero.png|-6|158|0|1|0|3|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_TestB= new Sprite("/res/sprites/SprHero.png");
		sprSpr_TestB.setTextID("Spr_TestB");
		sprSpr_TestB.setPos(-6, 158, 0);
		sprSpr_TestB.addState(sprSpr_TestB.new State("StateName0", 8, 0.09375f));
		sprSpr_TestB.addState(sprSpr_TestB.new State("StateName1", 8, 0.09375f));
		sprSpr_TestB.addState(sprSpr_TestB.new State("StateName2", 8, 0.09375f));
		sprSpr_TestB.addState(sprSpr_TestB.new State("StateName3", 8, 0.09375f));
		sprSpr_TestB.addState(sprSpr_TestB.new State("StateName4", 8, 0.09375f));
		sprSpr_TestB.addState(sprSpr_TestB.new State("StateName5", 8, 0.09375f));
		sprSpr_TestB.addState(sprSpr_TestB.new State("StateName6", 8, 0.09375f));
		sprSpr_TestB.addState(sprSpr_TestB.new State("StateName7", 8, 0.09375f));
		sprSpr_TestB.load();
		sprSpr_TestB.setCurState(0);
		sprSpr_TestB.setCurFrame(3);
		p_ctxUnder.addChild(sprSpr_TestB, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:12|Sprite|Spr_TestC|/res/sprites/SprHero.png|-10|203|0|1|0|0|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_TestC= new Sprite("/res/sprites/SprHero.png");
		sprSpr_TestC.setTextID("Spr_TestC");
		sprSpr_TestC.setPos(-10, 203, 0);
		sprSpr_TestC.addState(sprSpr_TestC.new State("StateName0", 8, 0.09375f));
		sprSpr_TestC.addState(sprSpr_TestC.new State("StateName1", 8, 0.09375f));
		sprSpr_TestC.addState(sprSpr_TestC.new State("StateName2", 8, 0.09375f));
		sprSpr_TestC.addState(sprSpr_TestC.new State("StateName3", 8, 0.09375f));
		sprSpr_TestC.addState(sprSpr_TestC.new State("StateName4", 8, 0.09375f));
		sprSpr_TestC.addState(sprSpr_TestC.new State("StateName5", 8, 0.09375f));
		sprSpr_TestC.addState(sprSpr_TestC.new State("StateName6", 8, 0.09375f));
		sprSpr_TestC.addState(sprSpr_TestC.new State("StateName7", 8, 0.09375f));
		sprSpr_TestC.load();
		sprSpr_TestC.setCurState(0);
		sprSpr_TestC.setCurFrame(0);
		p_ctxUnder.addChild(sprSpr_TestC, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:13|Sprite|Spr_TestD|/res/sprites/SprHero.png|47|-218|0|1|0|0|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_TestD= new Sprite("/res/sprites/SprHero.png");
		sprSpr_TestD.setTextID("Spr_TestD");
		sprSpr_TestD.setPos(47, -218, 0);
		sprSpr_TestD.addState(sprSpr_TestD.new State("StateName0", 8, 0.09375f));
		sprSpr_TestD.addState(sprSpr_TestD.new State("StateName1", 8, 0.09375f));
		sprSpr_TestD.addState(sprSpr_TestD.new State("StateName2", 8, 0.09375f));
		sprSpr_TestD.addState(sprSpr_TestD.new State("StateName3", 8, 0.09375f));
		sprSpr_TestD.addState(sprSpr_TestD.new State("StateName4", 8, 0.09375f));
		sprSpr_TestD.addState(sprSpr_TestD.new State("StateName5", 8, 0.09375f));
		sprSpr_TestD.addState(sprSpr_TestD.new State("StateName6", 8, 0.09375f));
		sprSpr_TestD.addState(sprSpr_TestD.new State("StateName7", 8, 0.09375f));
		sprSpr_TestD.load();
		sprSpr_TestD.setCurState(0);
		sprSpr_TestD.setCurFrame(0);
		p_ctxUnder.addChild(sprSpr_TestD, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:14|Sprite|Spr_TestE|/res/sprites/SprHero.png|45|-173|0|1|0|3|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_TestE= new Sprite("/res/sprites/SprHero.png");
		sprSpr_TestE.setTextID("Spr_TestE");
		sprSpr_TestE.setPos(45, -173, 0);
		sprSpr_TestE.addState(sprSpr_TestE.new State("StateName0", 8, 0.09375f));
		sprSpr_TestE.addState(sprSpr_TestE.new State("StateName1", 8, 0.09375f));
		sprSpr_TestE.addState(sprSpr_TestE.new State("StateName2", 8, 0.09375f));
		sprSpr_TestE.addState(sprSpr_TestE.new State("StateName3", 8, 0.09375f));
		sprSpr_TestE.addState(sprSpr_TestE.new State("StateName4", 8, 0.09375f));
		sprSpr_TestE.addState(sprSpr_TestE.new State("StateName5", 8, 0.09375f));
		sprSpr_TestE.addState(sprSpr_TestE.new State("StateName6", 8, 0.09375f));
		sprSpr_TestE.addState(sprSpr_TestE.new State("StateName7", 8, 0.09375f));
		sprSpr_TestE.load();
		sprSpr_TestE.setCurState(0);
		sprSpr_TestE.setCurFrame(3);
		p_ctxUnder.addChild(sprSpr_TestE, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:15|Sprite|Spr_TestF|/res/sprites/SprHero.png|43|-121|0|1|0|1|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_TestF= new Sprite("/res/sprites/SprHero.png");
		sprSpr_TestF.setTextID("Spr_TestF");
		sprSpr_TestF.setPos(43, -121, 0);
		sprSpr_TestF.addState(sprSpr_TestF.new State("StateName0", 8, 0.09375f));
		sprSpr_TestF.addState(sprSpr_TestF.new State("StateName1", 8, 0.09375f));
		sprSpr_TestF.addState(sprSpr_TestF.new State("StateName2", 8, 0.09375f));
		sprSpr_TestF.addState(sprSpr_TestF.new State("StateName3", 8, 0.09375f));
		sprSpr_TestF.addState(sprSpr_TestF.new State("StateName4", 8, 0.09375f));
		sprSpr_TestF.addState(sprSpr_TestF.new State("StateName5", 8, 0.09375f));
		sprSpr_TestF.addState(sprSpr_TestF.new State("StateName6", 8, 0.09375f));
		sprSpr_TestF.addState(sprSpr_TestF.new State("StateName7", 8, 0.09375f));
		sprSpr_TestF.load();
		sprSpr_TestF.setCurState(0);
		sprSpr_TestF.setCurFrame(1);
		p_ctxUnder.addChild(sprSpr_TestF, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:16|Sprite|Spr_TestG|/res/sprites/SprHero.png|41|-79|0|1|0|4|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_TestG= new Sprite("/res/sprites/SprHero.png");
		sprSpr_TestG.setTextID("Spr_TestG");
		sprSpr_TestG.setPos(41, -79, 0);
		sprSpr_TestG.addState(sprSpr_TestG.new State("StateName0", 8, 0.09375f));
		sprSpr_TestG.addState(sprSpr_TestG.new State("StateName1", 8, 0.09375f));
		sprSpr_TestG.addState(sprSpr_TestG.new State("StateName2", 8, 0.09375f));
		sprSpr_TestG.addState(sprSpr_TestG.new State("StateName3", 8, 0.09375f));
		sprSpr_TestG.addState(sprSpr_TestG.new State("StateName4", 8, 0.09375f));
		sprSpr_TestG.addState(sprSpr_TestG.new State("StateName5", 8, 0.09375f));
		sprSpr_TestG.addState(sprSpr_TestG.new State("StateName6", 8, 0.09375f));
		sprSpr_TestG.addState(sprSpr_TestG.new State("StateName7", 8, 0.09375f));
		sprSpr_TestG.load();
		sprSpr_TestG.setCurState(0);
		sprSpr_TestG.setCurFrame(4);
		p_ctxUnder.addChild(sprSpr_TestG, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:17|Sprite|Spr_TestH|/res/sprites/SprHero.png|42|-37|0|1|0|3|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_TestH= new Sprite("/res/sprites/SprHero.png");
		sprSpr_TestH.setTextID("Spr_TestH");
		sprSpr_TestH.setPos(42, -37, 0);
		sprSpr_TestH.addState(sprSpr_TestH.new State("StateName0", 8, 0.09375f));
		sprSpr_TestH.addState(sprSpr_TestH.new State("StateName1", 8, 0.09375f));
		sprSpr_TestH.addState(sprSpr_TestH.new State("StateName2", 8, 0.09375f));
		sprSpr_TestH.addState(sprSpr_TestH.new State("StateName3", 8, 0.09375f));
		sprSpr_TestH.addState(sprSpr_TestH.new State("StateName4", 8, 0.09375f));
		sprSpr_TestH.addState(sprSpr_TestH.new State("StateName5", 8, 0.09375f));
		sprSpr_TestH.addState(sprSpr_TestH.new State("StateName6", 8, 0.09375f));
		sprSpr_TestH.addState(sprSpr_TestH.new State("StateName7", 8, 0.09375f));
		sprSpr_TestH.load();
		sprSpr_TestH.setCurState(0);
		sprSpr_TestH.setCurFrame(3);
		p_ctxUnder.addChild(sprSpr_TestH, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:18|Sprite|Spr_TestI|/res/sprites/SprHero.png|38|10|0|1|0|1|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_TestI= new Sprite("/res/sprites/SprHero.png");
		sprSpr_TestI.setTextID("Spr_TestI");
		sprSpr_TestI.setPos(38, 10, 0);
		sprSpr_TestI.addState(sprSpr_TestI.new State("StateName0", 8, 0.09375f));
		sprSpr_TestI.addState(sprSpr_TestI.new State("StateName1", 8, 0.09375f));
		sprSpr_TestI.addState(sprSpr_TestI.new State("StateName2", 8, 0.09375f));
		sprSpr_TestI.addState(sprSpr_TestI.new State("StateName3", 8, 0.09375f));
		sprSpr_TestI.addState(sprSpr_TestI.new State("StateName4", 8, 0.09375f));
		sprSpr_TestI.addState(sprSpr_TestI.new State("StateName5", 8, 0.09375f));
		sprSpr_TestI.addState(sprSpr_TestI.new State("StateName6", 8, 0.09375f));
		sprSpr_TestI.addState(sprSpr_TestI.new State("StateName7", 8, 0.09375f));
		sprSpr_TestI.load();
		sprSpr_TestI.setCurState(0);
		sprSpr_TestI.setCurFrame(1);
		p_ctxUnder.addChild(sprSpr_TestI, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:19|Sprite|Spr_TestJ|/res/sprites/SprHero.png|39|55|0|1|0|4|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_TestJ= new Sprite("/res/sprites/SprHero.png");
		sprSpr_TestJ.setTextID("Spr_TestJ");
		sprSpr_TestJ.setPos(39, 55, 0);
		sprSpr_TestJ.addState(sprSpr_TestJ.new State("StateName0", 8, 0.09375f));
		sprSpr_TestJ.addState(sprSpr_TestJ.new State("StateName1", 8, 0.09375f));
		sprSpr_TestJ.addState(sprSpr_TestJ.new State("StateName2", 8, 0.09375f));
		sprSpr_TestJ.addState(sprSpr_TestJ.new State("StateName3", 8, 0.09375f));
		sprSpr_TestJ.addState(sprSpr_TestJ.new State("StateName4", 8, 0.09375f));
		sprSpr_TestJ.addState(sprSpr_TestJ.new State("StateName5", 8, 0.09375f));
		sprSpr_TestJ.addState(sprSpr_TestJ.new State("StateName6", 8, 0.09375f));
		sprSpr_TestJ.addState(sprSpr_TestJ.new State("StateName7", 8, 0.09375f));
		sprSpr_TestJ.load();
		sprSpr_TestJ.setCurState(0);
		sprSpr_TestJ.setCurFrame(4);
		p_ctxUnder.addChild(sprSpr_TestJ, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:20|Sprite|Spr_TestK|/res/sprites/SprHero.png|38|105|0|1|0|1|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_TestK= new Sprite("/res/sprites/SprHero.png");
		sprSpr_TestK.setTextID("Spr_TestK");
		sprSpr_TestK.setPos(38, 105, 0);
		sprSpr_TestK.addState(sprSpr_TestK.new State("StateName0", 8, 0.09375f));
		sprSpr_TestK.addState(sprSpr_TestK.new State("StateName1", 8, 0.09375f));
		sprSpr_TestK.addState(sprSpr_TestK.new State("StateName2", 8, 0.09375f));
		sprSpr_TestK.addState(sprSpr_TestK.new State("StateName3", 8, 0.09375f));
		sprSpr_TestK.addState(sprSpr_TestK.new State("StateName4", 8, 0.09375f));
		sprSpr_TestK.addState(sprSpr_TestK.new State("StateName5", 8, 0.09375f));
		sprSpr_TestK.addState(sprSpr_TestK.new State("StateName6", 8, 0.09375f));
		sprSpr_TestK.addState(sprSpr_TestK.new State("StateName7", 8, 0.09375f));
		sprSpr_TestK.load();
		sprSpr_TestK.setCurState(0);
		sprSpr_TestK.setCurFrame(1);
		p_ctxUnder.addChild(sprSpr_TestK, false, false);

		/*DATA_SPRITE_TEMPLATE:#|CLASS_ID|NAME|RESSOURCE_NAME|POS_X|POS_Y|POS_Z|DEEPNESS|DEFAULT_STATE|DEFAULT_FRAME|NB_STATES|STATE_NAME|STATE_NB_FRAMES|STATE_SPEED*/
		/*DATA:21|Sprite|Spr_TestL|/res/sprites/SprHero.png|34|151|0|1|0|0|8|StateName0|8|0.09375|StateName1|8|0.09375|StateName2|8|0.09375|StateName3|8|0.09375|StateName4|8|0.09375|StateName5|8|0.09375|StateName6|8|0.09375|StateName7|8|0.09375|*/
		Sprite sprSpr_TestL= new Sprite("/res/sprites/SprHero.png");
		sprSpr_TestL.setTextID("Spr_TestL");
		sprSpr_TestL.setPos(34, 151, 0);
		sprSpr_TestL.addState(sprSpr_TestL.new State("StateName0", 8, 0.09375f));
		sprSpr_TestL.addState(sprSpr_TestL.new State("StateName1", 8, 0.09375f));
		sprSpr_TestL.addState(sprSpr_TestL.new State("StateName2", 8, 0.09375f));
		sprSpr_TestL.addState(sprSpr_TestL.new State("StateName3", 8, 0.09375f));
		sprSpr_TestL.addState(sprSpr_TestL.new State("StateName4", 8, 0.09375f));
		sprSpr_TestL.addState(sprSpr_TestL.new State("StateName5", 8, 0.09375f));
		sprSpr_TestL.addState(sprSpr_TestL.new State("StateName6", 8, 0.09375f));
		sprSpr_TestL.addState(sprSpr_TestL.new State("StateName7", 8, 0.09375f));
		sprSpr_TestL.load();
		sprSpr_TestL.setCurState(0);
		sprSpr_TestL.setCurFrame(0);
		p_ctxUnder.addChild(sprSpr_TestL, false, false);

	}
}
