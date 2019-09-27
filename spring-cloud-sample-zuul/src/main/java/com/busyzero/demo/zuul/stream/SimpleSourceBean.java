package com.busyzero.demo.zuul.stream;

import com.busyzero.demo.stream.model.OrganizationChangeModel;
import com.busyzero.demo.stream.utils.UserContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(Source.class)
public class SimpleSourceBean {
    private Source source;
    private static final Logger logger = LoggerFactory.getLogger(SimpleSourceBean.class);

    @Autowired
    public SimpleSourceBean(Source source) {
        this.source = source;
    }

    public void publishOrgChange(String action,  String orgId) {
        logger.debug("sending kafka message{} for org id:{}", action, orgId);
        OrganizationChangeModel model = new OrganizationChangeModel(
                OrganizationChangeModel.class.getTypeName(),
                action,
                orgId,
                UserContextHolder.curUserContenxt().getCorrelationId());
        source.output().send(MessageBuilder.withPayload(model).build());
    }
}
