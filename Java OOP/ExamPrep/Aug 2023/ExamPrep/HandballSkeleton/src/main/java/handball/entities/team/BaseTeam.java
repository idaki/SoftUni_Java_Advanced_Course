package handball.entities.team;

import handball.utils.IntegerUtils;
import handball.utils.StringUtils;

import static handball.common.ExceptionMessages.*;

public abstract class BaseTeam implements Team {

    private String name;
    private String country;
    private int advantage;

    public BaseTeam(String name, String country, int advantage) {
        setName(name);
        setCountry(country);
        setAdvantage(advantage);
    }

    @Override
    public void setName(String name) {
        if (StringUtils.isNullOrEmpty(name)) {
            throw new NullPointerException(TEAM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;

    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAdvantage() {
        return this.advantage;
    }

    public void setCountry(String country) {
        if (StringUtils.isNullOrEmpty(country)) {
            throw new NullPointerException(TEAM_COUNTRY_NULL_OR_EMPTY);
        }
        this.country = country;
    }

    public void setAdvantage(int advantage) {
        if (IntegerUtils.isSmallerOrEqualToZero(advantage)) {
            throw new IllegalArgumentException(TEAM_ADVANTAGE_BELOW_OR_EQUAL_ZERO);
        }

        this.advantage = advantage;
    }

    public String getCountry() {
        return this.country;
    }
}
