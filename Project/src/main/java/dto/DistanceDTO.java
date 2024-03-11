package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 모든 필드의 Getter, Setter, equals(), hashCode(), toString() 메서드를 생성합니다.
@NoArgsConstructor // 파라미터가 없는 기본 생성자를 생성합니다.
@AllArgsConstructor // 모든 필드를 인자로 받는 생성자를 생성합니다.
@Builder // 빌더 패턴을 사용하여 객체를 생성할 수 있게 합니다.
public class DistanceDTO {

		private String distance;
	    private String mgr_no;
	    private String wrdofc;
	    private String main_nm;
	    private String adres1;
	    private String adres2;
	    private String floor;
	    private String instl_ty;
	    private String instl_mby;
	    private String svc_se;
	    private String cmcwr;
	    private String cnstc_year;
	    private String inout_door;
	    private String remars3;
	    private String lat;
	    private String lnt;
	    private String work_dttm;
	
}
