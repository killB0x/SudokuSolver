package Resources;

import Solver.Board;
import org.json.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/solve")
public class SolverResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getSolution(String input) {
        JSONObject json = new JSONObject(input);
        Board board = new Board();
        for(int i = 0; i < Board.SIZE; i++) {
            for(int j = 0; j < Board.SIZE; j++) {
                board.setCell(i,j,json.getInt(String.valueOf(i*10+j)));
            }
        }
        board = Solver.Solver.solveSudoku(board);
        String jsonResponse = "{";
        for(int i = 0; i < Board.SIZE; i++) {
            for(int j = 0; j < Board.SIZE; j++) {
                int key = i*10+j;
                jsonResponse += "\""+ key +"\":\""+board.getBoard()[i][j]+"\"";
                if(i!=Board.SIZE-1 && j!=Board.SIZE-1) {
                    jsonResponse += ",";
                }
            }
        }
        jsonResponse +="}";
        return jsonResponse;
    }

}
