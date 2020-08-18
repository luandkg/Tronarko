package TronarkoMain;

import OmegaEngine.Windows;
import OmegaEngine.Utils.Imaginador;
import OmegaEngine.Utils.Local;

public class TronarkoMain {

	public static void main(String[] args) {

		Windows mWindows = new Windows("Tronarko V2", 1500, 1020);


		mWindows.setIconImage(Imaginador.CarregarStream(Local.Carregar("editor.png")));

		mWindows.CriarCenarioAplicavel(new TronarkoCena(mWindows));
		
		//mWindows.CriarCenarioAplicavel(new HarrempluzCena(mWindows));

		Thread mThread = new Thread(mWindows);
		mThread.start();

	}
}
