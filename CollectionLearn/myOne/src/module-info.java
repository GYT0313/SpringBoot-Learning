import com.gyt3.MyService;
import com.gyt3.impl.Czxy;
import com.gyt3.impl.Itheima;

module myOne {
    exports com.gyt1;
    exports com.gyt2;
    exports com.gyt3;

//    provides MyService with Itheima;
    provides MyService with Czxy;
}