package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: SnapshotFlow.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0000\u0010\u0002*\u0002H\u0007\"\u0004\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\b\u001a\u0002H\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001a-\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\r\u001a%\u0010\u000e\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013H\u0002¢\u0006\u0002\b\u0014¨\u0006\u0015"}, d2 = {"snapshotFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "block", "Lkotlin/Function0;", "collectAsState", "Landroidx/compose/runtime/State;", "R", "initial", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Lkotlinx/coroutines/flow/StateFlow;", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "intersects", "", "Landroidx/collection/MutableScatterSet;", "", "set", "", "intersects$SnapshotStateKt__SnapshotFlowKt", "runtime_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
/* loaded from: classes.dex */
final /* synthetic */ class SnapshotStateKt__SnapshotFlowKt {
    public static final <T> State<T> collectAsState(StateFlow<? extends T> stateFlow, CoroutineContext context, Composer $composer, int $changed, int i) {
        CoroutineContext context2;
        ComposerKt.sourceInformationMarkerStart($composer, -1439883919, "C(collectAsState)47@1847L30:SnapshotFlow.kt#9igjgp");
        if ((i & 1) != 0) {
            CoroutineContext context3 = EmptyCoroutineContext.INSTANCE;
            context2 = context3;
        } else {
            context2 = context;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1439883919, $changed, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:47)");
        }
        State<T> stateCollectAsState = SnapshotStateKt.collectAsState(stateFlow, stateFlow.getValue(), context2, $composer, ($changed & 14) | (($changed << 3) & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stateCollectAsState;
    }

    public static final <T extends R, R> State<R> collectAsState(Flow<? extends T> flow, R r, CoroutineContext context, Composer $composer, int $changed, int i) {
        CoroutineContext context2;
        SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1 value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -606625098, "C(collectAsState)P(1)63@2516L149,63@2479L186:SnapshotFlow.kt#9igjgp");
        if ((i & 2) != 0) {
            CoroutineContext context3 = EmptyCoroutineContext.INSTANCE;
            context2 = context3;
        } else {
            context2 = context;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-606625098, $changed, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:63)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -498558367, "CC(remember):SnapshotFlow.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance(context2) | $composer.changedInstance(flow);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1(context2, flow, null);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        State<R> stateProduceState = SnapshotStateKt.produceState(r, flow, context2, (Function2) value$iv, $composer, (($changed >> 3) & 8) | (($changed >> 3) & 14) | (($changed << 3) & 112) | ($changed & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stateProduceState;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SnapshotFlow.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1", f = "SnapshotFlow.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {146, 150, 172}, m = "invokeSuspend", n = {"$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "found", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    /* renamed from: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1, reason: invalid class name */
    static final class AnonymousClass1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<T> $block;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function0<? extends T> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$block = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$block, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:91:0x00e6, code lost:
        
            r5 = r3;
            r6 = r7;
            r7 = r8;
            r8 = r9;
            r9 = r10;
            r10 = r11;
            r11 = r12;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:36:0x0113, B:40:0x011c], limit reached: 89 */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0101 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x012c A[Catch: all -> 0x0196, TRY_LEAVE, TryCatch #3 {all -> 0x0196, blocks: (B:33:0x010e, B:36:0x0113, B:41:0x011d, B:44:0x012c, B:51:0x014d, B:53:0x0159, B:63:0x0185, B:64:0x0188, B:46:0x013b, B:50:0x0148, B:60:0x0180, B:61:0x0183, B:48:0x0142), top: B:84:0x010e, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0189  */
        /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r11v10, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v12 */
        /* JADX WARN: Type inference failed for: r11v15 */
        /* JADX WARN: Type inference failed for: r11v3, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r11v7 */
        /* JADX WARN: Type inference failed for: r11v8 */
        /* JADX WARN: Type inference failed for: r11v9 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0173 -> B:57:0x017a). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 440
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final <T> Flow<T> snapshotFlow(Function0<? extends T> function0) {
        return FlowKt.flow(new AnonymousClass1(function0, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean intersects$SnapshotStateKt__SnapshotFlowKt(MutableScatterSet<Object> mutableScatterSet, Set<? extends Object> set) {
        ScatterSet this_$iv;
        ScatterSet this_$iv2;
        char c;
        MutableScatterSet<Object> this_$iv3 = mutableScatterSet;
        Object[] k$iv$iv = this_$iv3.elements;
        long[] m$iv$iv$iv = this_$iv3.metadata;
        int lastIndex$iv$iv$iv = m$iv$iv$iv.length - 2;
        int i$iv$iv$iv = 0;
        if (0 <= lastIndex$iv$iv$iv) {
            while (true) {
                long slot$iv$iv$iv = m$iv$iv$iv[i$iv$iv$iv];
                long slot$iv$iv$iv2 = slot$iv$iv$iv;
                if ((((~slot$iv$iv$iv) << 7) & slot$iv$iv$iv & (-9187201950435737472L)) != -9187201950435737472L) {
                    int bitCount$iv$iv$iv = 8 - ((~(i$iv$iv$iv - lastIndex$iv$iv$iv)) >>> 31);
                    int j$iv$iv$iv = 0;
                    while (j$iv$iv$iv < bitCount$iv$iv$iv) {
                        long value$iv$iv$iv$iv = slot$iv$iv$iv2 & 255;
                        if (value$iv$iv$iv$iv < 128) {
                            int index$iv$iv$iv = (i$iv$iv$iv << 3) + j$iv$iv$iv;
                            Object element$iv = k$iv$iv[index$iv$iv$iv];
                            this_$iv2 = this_$iv3;
                            c = '\b';
                            if (set.contains(element$iv)) {
                                return true;
                            }
                        } else {
                            this_$iv2 = this_$iv3;
                            c = '\b';
                        }
                        slot$iv$iv$iv2 >>= c;
                        j$iv$iv$iv++;
                        this_$iv3 = this_$iv2;
                    }
                    this_$iv = this_$iv3;
                    if (bitCount$iv$iv$iv != 8) {
                        break;
                    }
                } else {
                    this_$iv = this_$iv3;
                }
                if (i$iv$iv$iv == lastIndex$iv$iv$iv) {
                    break;
                }
                i$iv$iv$iv++;
                this_$iv3 = this_$iv;
            }
        }
        return false;
    }
}
