package org.optaplanner.core.impl.testdata.domain.chained;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.optaplanner.core.api.domain.variable.PlanningVariableGraphType;
import org.optaplanner.core.impl.domain.entity.descriptor.EntityDescriptor;
import org.optaplanner.core.impl.domain.solution.descriptor.SolutionDescriptor;
import org.optaplanner.core.impl.domain.variable.descriptor.GenuineVariableDescriptor;
import org.optaplanner.core.impl.testdata.domain.TestdataObject;

@PlanningEntity
public class TestdataChainedEntity extends TestdataObject implements TestdataChainedObject {

    public static EntityDescriptor buildEntityDescriptor() {
        SolutionDescriptor solutionDescriptor = TestdataChainedSolution.buildSolutionDescriptor();
        return solutionDescriptor.findEntityDescriptorOrFail(TestdataChainedEntity.class);
    }

    public static GenuineVariableDescriptor buildVariableDescriptorForChainedObject() {
        SolutionDescriptor solutionDescriptor = TestdataChainedSolution.buildSolutionDescriptor();
        EntityDescriptor entityDescriptor = solutionDescriptor.findEntityDescriptorOrFail(TestdataChainedEntity.class);
        return entityDescriptor.getGenuineVariableDescriptor("chainedObject");
    }

    private TestdataChainedObject chainedObject;

    public TestdataChainedEntity() {
    }

    public TestdataChainedEntity(String code) {
        super(code);
    }

    public TestdataChainedEntity(String code, TestdataChainedObject chainedObject) {
        this(code);
        this.chainedObject = chainedObject;
    }

    @PlanningVariable(valueRangeProviderRefs = {"chainedAnchorRange", "chainedEntityRange"},
            graphType = PlanningVariableGraphType.CHAINED)
    public TestdataChainedObject getChainedObject() {
        return chainedObject;
    }

    public void setChainedObject(TestdataChainedObject chainedObject) {
        this.chainedObject = chainedObject;
    }

    // ************************************************************************
    // Complex methods
    // ************************************************************************

}