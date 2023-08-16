package com.assessment.Springbootassessment;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.PageImpl;

@Component
public class CarDao {
	private static List<CarObject> carList = new ArrayList<>();
	static {
    CarObject car1 = new CarObject();
    car1.setId(6);
    car1.setCarname("3 MPS");
    car1.setBrand("Mazda");
    car1.setDescription("Blab la bla");

    VarianceObject variance1 = new VarianceObject();
    variance1.setId(1);
    variance1.setName("Full Spec");
    variance1.setPrice(175000);

    VarianceObject variance2 = new VarianceObject();
    variance2.setId(2);
    variance2.setName("Manual Spec");
    variance2.setPrice(105000);

    List<VarianceObject> varianceList1 = new ArrayList<>();
    varianceList1.add(variance1);
    varianceList1.add(variance2);

    car1.setVariance(varianceList1);
    carList.add(car1);

    CarObject car2 = new CarObject();
    car2.setId(7);
    car2.setCarname("RS 250 Cup");
    car2.setBrand("Renault");
    car2.setDescription("Blab la bla");

    VarianceObject variance3 = new VarianceObject();
    variance3.setId(2);
    variance3.setName("Full Spec");
    variance3.setPrice(1375000);

    VarianceObject variance4 = new VarianceObject();
    variance4.setId(3);
    variance4.setName("Manual Spec");
    variance4.setPrice(1105000);

    List<VarianceObject> varianceList2 = new ArrayList<>();
    varianceList2.add(variance3);
    varianceList2.add(variance4);

    car2.setVariance(varianceList2);

    carList.add(car2);
	}
	
	public Page<CarObject> paginationCar(int pageindex, int pagesize) {
	    Pageable page = PageRequest.of(pageindex, pagesize);
	    List<CarObject> resultList = findAll(page);
        return new PageImpl<>(resultList, page, carList.size());
	}

	public List<CarObject> findAll(Pageable page) {
	    return carList;
	}

}
