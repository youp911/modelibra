/*
 * Modelibra
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package game.wicket.app;

import game.Game;
import game.GameConfig;
import game.PersistentGame;

import org.modelibra.wicket.app.DomainApp;

/**
 * Game domain web application.
 * 
 * @author Dzenan Ridjanovic
 * @version 2007-04-06
 */
public class GameApp extends DomainApp {

	/**
	 * Constructs the domain web application.
	 */
	public GameApp() {
		super(new PersistentGame(new Game(new GameConfig().getDomainConfig())));
	}

	/**
	 * Gets the Game domain.
	 * 
	 * @return Game domain
	 */
	public Game getGame() {
		return (Game) super.getDomain();
	}

	/* ============================= */
	/* ======= SPECIFIC CODE ======= */
	/* ============================= */

}
