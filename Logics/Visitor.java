package Logics;
import Creeps.Creep;
import Creeps.Goli;
import Creeps.Knight;
import Creeps.Mike;
import Creeps.Naji;


public interface Visitor {

	void visit(Goli g);
	void visit(Knight k);
	void visit(Mike m);
	void visit(Naji n);
	
	
}
