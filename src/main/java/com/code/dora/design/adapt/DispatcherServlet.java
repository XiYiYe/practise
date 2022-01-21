package com.code.dora.design.adapt;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟SpringMvc的dispatcherServlet
 *
 */
public class DispatcherServlet {

    private List<HandleAdapter> handleAdapters;

    public DispatcherServlet() {
        this.handleAdapters = new ArrayList<>();
        handleAdapters.add(new AnnotationHandlerAdapter());
        handleAdapters.add(new HttpHandleAdapter());
        handleAdapters.add(new ServletHandleAdapter());
    }

    public void disPatcher() {
        AnnotationController controller = new AnnotationController();
        HandleAdapter handleAdapter = getHandleAdapter(controller);
        handleAdapter.handle(controller);
    }

    private HandleAdapter getHandleAdapter(Controller controller) {
        if (handleAdapters == null) {
            return new AnnotationHandlerAdapter();
        }
        for (HandleAdapter handleAdapter : handleAdapters) {
            if (handleAdapter.support(controller)) {
                return handleAdapter;
            }
        }
        return new AnnotationHandlerAdapter();
    }

}
