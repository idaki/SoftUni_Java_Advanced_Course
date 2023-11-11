package christmasPastryShop.core;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.OpenBooth;
import christmasPastryShop.entities.booths.PrivateBooth;
import christmasPastryShop.entities.cocktails.Hibernation;
import christmasPastryShop.entities.cocktails.MulledWine;
import christmasPastryShop.entities.delicacies.Stolen;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class ControllerImpl implements Controller {
    DelicacyRepository<Delicacy> delicacyRepository;
    CocktailRepository<Cocktail> cocktailRepository;
    BoothRepository<Booth> boothRepository;
    private double income;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository
            , CocktailRepository<Cocktail> cocktailRepository
            , BoothRepository<Booth> boothRepository) {

        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository= boothRepository;
       this.income = 0;
    }

        @Override
        public String addDelicacy (String type, String name,double price){
            if (this.delicacyRepository.getByName(name) != null) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST
                        , type
                        , name));
            }
            Delicacy delicacy;
            if ("Gingerbread".equals(type)) {
                delicacy = new Stolen(name, price);
                delicacyRepository.add(delicacy);
            } else if ("Stolen".equals(type)) {
                delicacy = new Stolen(name, price);
                delicacyRepository.add(delicacy);
            }




            return String.format(OutputMessages.DELICACY_ADDED
                    , name
                    , type);
        }

        @Override
        public String addCocktail (String type, String name,int size, String brand){
            //TODO

            if (this.cocktailRepository.getByName(name) != null) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST
                        , type
                        , name));
            }

            Cocktail cocktail;
            if ("MulledWine".equals(type)) {
                cocktail = new MulledWine(name, size, brand);
                cocktailRepository.add(cocktail);
            } else if ("Hibernation".equals(type)) {
                cocktail = new Hibernation(name, size, brand);
                cocktailRepository.add(cocktail);
            }


            return String.format(OutputMessages.COCKTAIL_ADDED
                    , name
                    , brand);
        }

        @Override
        public String addBooth (String type,int boothNumber, int capacity){
            //TODO
            boolean isExisting = false;

            if (this.boothRepository.getByNumber(boothNumber) == null){
                isExisting =true;
            }

            Booth booth;
            if ("OpenBooth".equals(type)&& !isExisting) {
                booth = new OpenBooth(boothNumber, capacity);
                boothRepository.add(booth);
            } else if ("PrivateBooth".equals(type)&& !isExisting) {
                booth = new PrivateBooth(boothNumber, capacity);
                boothRepository.add(booth);
            } else if (isExisting){
                throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST
                        , boothNumber));
            }
            return String.format(OutputMessages.BOOTH_ADDED
                    , boothNumber);
        }

        @Override
        public String reserveBooth ( int numberOfPeople){
            Booth booth = boothRepository.getAll().stream()
                    .filter(b -> !b.isReserved() && b.getCapacity() >= numberOfPeople)
                    .findFirst().orElse(null);

            String message = "";
            if (booth == null) {
                message = String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
            } else {
                int boothNum = booth.getBoothNumber();
                booth.reserve(numberOfPeople);

                message = String.format(OutputMessages.BOOTH_RESERVED, boothNum, numberOfPeople);
            }
            return message;
        }

        @Override
        public String leaveBooth ( int boothNumber){
            Booth booth = boothRepository.getByNumber(boothNumber);

            //TODO check calculation

            double bill = booth.getPrice();
            income+=bill;
            booth.clear();
            return String.format(OutputMessages.BILL
                    , boothNumber
                    , bill).trim();
        }

        @Override
        public String getIncome () {
            //TODO

            return String.format(OutputMessages.TOTAL_INCOME
                    ,this.income).trim();
        }
}
