package magicGame.models.magicians;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

public abstract class MagicianImpl implements Magician{
    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    public MagicianImpl(String username, int health, int protection, Magic magic) {
        this.setUsername( username);
        this.setHealth(health);
        this.setProtection(protection);
        this.isAlive = true;
        this.setMagic(magic);
    }

    protected void setUsername(String username) {
        if (username == null || username.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    protected void setHealth(int health) {
        if (health<0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    protected void setProtection(int protection) {
        if (protection<0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    protected void setAlive(boolean alive) {
        isAlive = alive;
    }

    protected void setMagic(Magic magic) {
        if (magic == null){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC);
        }
        this.magic = magic;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.protection;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    @Override
    public Magic getMagic() {
        return this.magic;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }
//Todo could be false logic
    @Override
    public void takeDamage(int points) {
        boolean isProtectionEnough = this.protection>= points ;
        if (isProtectionEnough){
            this.protection -= points;

        }else{
            this.health -= points - this.protection;
        }
        if (this.health<=0){
            this.setAlive(false);
        }
    }

    @Override
    public String toString() {

        return String.format("%s: %s%n",this.getClass().getSimpleName(),this.username)
                +String.format("Health: %d%n",this.health)
                +String.format("Protection: &d%n",this.protection )
                +String.format("Magic: %d%n",this.magic.getName()).trim();
    }
}
