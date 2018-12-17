package jp.ac.uryukyu.ie.e185719;

import jdk.jfr.DataAmount;

/**
 * 名前、HP、攻撃などのHero,Enemyで同じ行動をするものを共通化したクラス。
 */
public class LivingThing {
    /**
     * String name; 名前
     * int hitPoint; HP
     * int attack; 攻撃力
     * boolean dead; 生死状態を判別/true=死亡
     */
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、HP、攻撃力を指定する。
     * @param name　名前
     * @param hitPoint　HP
     * @param attack 攻撃力
     */
    public LivingThing(String name, int hitPoint, int attack){
        this.name = name;
        this.hitPoint = hitPoint;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }

    public boolean isDead(){
        return dead;
    }

    public void setDead(boolean dead){
        this.dead = dead;
    }

    public String getName(){
        return name;
    }


    public int getHitPoint(){
        return hitPoint;
    }

    public void setHitPoint(int damage){
        this.hitPoint -= damage;
    }

    public int getAttack(){
        return attack;
    }

    /**
     * 攻撃判定。
     * attackに応じて乱数でダメージを算出し、wounded()でダメージ処理をする。
     * @param opponent　コンストラクタの情報。
     */
    public void attack(LivingThing opponent) {
        if(dead==false) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }else if(dead==true){
            int damage = 0;
            System.out.printf("%sは死んでいる。\n", name, opponent.getName(), damage);
        }
    }

    /**
     * ダメージ判定。
     * attack()によって算出されたダメージをHPから引く。
     * @param damage　ダメージ量
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}
