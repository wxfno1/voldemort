/*
 * Copyright 2010 LinkedIn, Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package voldemort.store.routed;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import voldemort.cluster.Node;

public class ListStateData extends PipelineData {

    private final List<RequestCompletedCallback> interimResults;

    private final List<Node> nodes;

    private final AtomicInteger nodeIndex;

    private final AtomicInteger successes;

    public ListStateData() {
        this.interimResults = new ArrayList<RequestCompletedCallback>();
        this.nodes = new ArrayList<Node>();
        this.nodeIndex = new AtomicInteger(0);
        this.successes = new AtomicInteger(0);
    }

    public List<RequestCompletedCallback> getInterimResults() {
        return interimResults;
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public int getNodeIndex() {
        return nodeIndex.get();
    }

    public void incrementNodeIndex() {
        nodeIndex.incrementAndGet();
    }

    public int getSuccesses() {
        return successes.get();
    }

    public void incrementSuccesses() {
        successes.incrementAndGet();
    }

}