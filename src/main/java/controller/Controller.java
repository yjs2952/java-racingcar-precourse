package controller;

import domain.*;
import view.InputView;
import view.PrintView;

public class Controller {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        PrintView printView = new PrintView();
        inputView.inputNames();
        inputView.inputTryCount();

        RacingGame racingGame = new RacingGame(Cars.of(inputView.getNames()), new RandomNumberMovingStrategy());
        racingGame.start(inputView.getTryCount());
        printView.print(racingGame.result());
    }
}
