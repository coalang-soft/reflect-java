package io.github.coalangsoft.reflect;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.sequence.SequenceTool;

public class AbstractMultipleCallableSequence extends MultipleCallableSequence<SingleCallable, AbstractMultipleCallableSequence> {

	public AbstractMultipleCallableSequence(SingleCallable[] values) {
		super(new SequenceTool<SingleCallable,AbstractMultipleCallableSequence>(new Func<SingleCallable[], AbstractMultipleCallableSequence>() {
			@Override
			public AbstractMultipleCallableSequence call(SingleCallable[] p) {
				return new AbstractMultipleCallableSequence(p);
			}
		}, new Func<Integer, SingleCallable[]>() {
			@Override
			public SingleCallable[] call(Integer p) {
				return new SingleCallable[p];
			}
		}), values);
	}

}
