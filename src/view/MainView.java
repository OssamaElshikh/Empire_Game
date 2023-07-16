package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import engine.City;
import engine.Game;

public class MainView extends JFrame implements ActionListener {

	private Game game;
	private WelcomePage welcomeview;
	private GeneralInfo GeneralInfo;
	private GameView GameView;
	private Cairo cairo;
	private Rome rome;
	private Sparta sparta;
	private JButton endturn;

	public MainView() {
		welcomeview = new WelcomePage(this);
		welcomeview.setBounds(0, 0, 1035, 745);
		this.getContentPane().add(welcomeview);

		this.getContentPane().setLayout(null);
		this.setTitle("Empire");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1035, 745);
		this.setVisible(true);

	}

	public void ends(String text, String city) {
		welcomeview.setVisible(false);
		try {
			game = new Game(text, city);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println((String) getWelcomeview().getBox()); // TEST BAS
		System.out.println(getGame().getPlayer().getControlledCities().get(0).getName()); // TEST BAS

		GameView = new GameView(this);
		GameView.setBounds(0, -50, 1200, 900);
		this.getContentPane().add(GameView);
		GameView.setVisible(true);

		// general info

		// battle view

		endturn = new JButton("End Turn");
		endturn.setBounds(10, 300, 150, 30);
		endturn.setVisible(true);
		endturn.setOpaque(true);
		endturn.setBackground(Color.black);
		this.add(endturn);
		endturn.addActionListener(this);

	}

	public void opencairo() { // opens the city

		cairo = new Cairo(this);
		cairo.setBounds(0, 0, 1035, 750);
		this.add(cairo);
		cairo.setVisible(true);
		GameView.setVisible(false);
		this.getCairo().showBuildings();

	}

	public void openrome() { // opens the city
		rome = new Rome(this);
		rome.setBounds(0, 0, 1035, 750);
		this.add(rome);
		rome.setVisible(true);
		GameView.setVisible(false);

	}

	public void opensparta() { // opens the city
		sparta = new Sparta(this);
		sparta.setBounds(0, 0, 1035, 750);
		this.add(sparta);
		sparta.setVisible(true);
		GameView.setVisible(false);

	}

	public void endcairo() { // closes the city
		this.getCairo().showBuildings();
		GameView.setVisible(true);
		cairo.setVisible(false);

	}

	public void endrome() { // closes the city
		GameView.setVisible(true);
		rome.setVisible(false);

	}

	public void endsparta() { // closes the city
		GameView.setVisible(true);
		sparta.setVisible(false);

	}

	public Game getGame() {
		return game;
	}

	public WelcomePage getWelcomeview() {
		return welcomeview;
	}

	public void openbattleview() { // opens the city
		BattleView battleview = new BattleView(this);
		battleview.setBounds(0, 0, 1035, 750);
		this.add(battleview);
		battleview.setVisible(true);
		GameView.setVisible(false);
	}

	public void updatelabels() {
		GeneralInfo.getGold().setText("Gold: " + "" + getGame().getPlayer().getTreasury());
		GeneralInfo.getFood().setText("Food: " + "" + getGame().getPlayer().getFood());
		GeneralInfo.getTurns().setText("Turns: " + "" + getGame().getCurrentTurnCount());
	}

	public GeneralInfo getGeneralInfo() {
		return GeneralInfo;
	}

	public GameView getGameView() {
		return GameView;
	}

	public Cairo getCairo() {
		return cairo;
	}

	public Rome getRome() {
		return rome;
	}

	public Sparta getSparta() {
		return sparta;
	}

	public static void main(String[] args) {
		MainView m = new MainView();
		/*
		 * System.out.println( (String) m.getWelcomeview().getBox() );
		 * City c= m.getGame().getPlayer().getControlledCities().get(0);
		 * System.out.println(c.getName());
		 */

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == endturn) {
			game.endTurn();
			// updatelabels();
		}

	}

}
