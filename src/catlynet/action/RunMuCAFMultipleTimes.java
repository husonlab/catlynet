/*
 * RunMuCAFMultipleTimes.java Copyright (C) 2020. Daniel H. Huson
 *
 *  (Some files contain contributions from other authors, who are then mentioned separately.)
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package catlynet.action;

import catlynet.algorithm.MuCAFAlgorithm;
import catlynet.main.Version;
import catlynet.window.MainWindow;
import catlynet.window.MainWindowController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import jloda.util.Basic;
import jloda.util.ProgramProperties;

import java.util.Optional;

/**
 * run the mu CAF heuristic multiple times
 * Daniel Huson, 2.2020
 */
public class RunMuCAFMultipleTimes {
    public static void apply(MainWindow window, MainWindowController controller, ChangeListener<Boolean> runningListener) {
        final TextInputDialog dialog = new TextInputDialog("10");
        dialog.setTitle("Setup mu-CAF algorithm - " + Version.SHORT_DESCRIPTION);
        dialog.setHeaderText("Randomized mu-CAF algorithm");
        dialog.setContentText("Number of runs:");
        ((Stage) dialog.getDialogPane().getScene().getWindow()).getIcons().addAll(ProgramProperties.getProgramIconsFX());

        final StringProperty inputString = new SimpleStringProperty();
        final Optional<String> result = dialog.showAndWait();

        result.ifPresent(name -> inputString.set(result.get()));

        if (Basic.isInteger(inputString.get()) && Basic.parseInt(inputString.get()) > 0) {
            final TextArea textArea = window.getTabManager().getTextArea(MuCAFAlgorithm.Name);
            MultiRunAlgorithm.apply(window, window.getInputReactionSystem(), new MuCAFAlgorithm(), textArea, Basic.parseInt(inputString.get()), runningListener);
        }
    }
}
