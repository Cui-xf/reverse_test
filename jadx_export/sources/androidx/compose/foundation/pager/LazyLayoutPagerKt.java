package androidx.compose.foundation.pager;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.reflect.KProperty0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: LazyLayoutPager.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÞ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"21\u0010#\u001a-\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010$¢\u0006\u0002\b'¢\u0006\u0002\b(H\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u0081\u0001\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010\u0004\u001a\u00020\u000521\u0010#\u001a-\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010$¢\u0006\u0002\b'¢\u0006\u0002\b(2#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00182\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100,H\u0003¢\u0006\u0002\u0010/\u001a\u0014\u00100\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"Pager", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "index", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Pager-uYRUAWA", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZIFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "rememberPagerItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "pageCount", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "dragDirectionDetector", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyLayoutPagerKt {
    /* JADX WARN: Removed duplicated region for block: B:109:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0549  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0586  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0589  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012b  */
    /* renamed from: Pager-uYRUAWA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m921PageruYRUAWA(final androidx.compose.ui.Modifier r27, final androidx.compose.foundation.pager.PagerState r28, final androidx.compose.foundation.layout.PaddingValues r29, final boolean r30, final androidx.compose.foundation.gestures.Orientation r31, final androidx.compose.foundation.gestures.TargetedFlingBehavior r32, final boolean r33, int r34, float r35, final androidx.compose.foundation.pager.PageSize r36, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r37, final kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r38, final androidx.compose.ui.Alignment.Horizontal r39, final androidx.compose.ui.Alignment.Vertical r40, final androidx.compose.foundation.gestures.snapping.SnapPosition r41, final kotlin.jvm.functions.Function4<? super androidx.compose.foundation.pager.PagerScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, androidx.compose.runtime.Composer r43, final int r44, final int r45, final int r46) {
        /*
            Method dump skipped, instructions count: 1453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.LazyLayoutPagerKt.m921PageruYRUAWA(androidx.compose.ui.Modifier, androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.gestures.Orientation, androidx.compose.foundation.gestures.TargetedFlingBehavior, boolean, int, float, androidx.compose.foundation.pager.PageSize, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.snapping.SnapPosition, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final Function0<PagerLazyLayoutItemProvider> rememberPagerItemProviderLambda(final PagerState state, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Function1<? super Integer, ? extends Object> function1, final Function0<Integer> function0, Composer $composer, int $changed) {
        PropertyReference0Impl value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -1372505274, "C(rememberPagerItemProviderLambda)P(3,1)259@10522L33,260@10576L25,261@10613L677:LazyLayoutPager.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1372505274, $changed, -1, "androidx.compose.foundation.pager.rememberPagerItemProviderLambda (LazyLayoutPager.kt:258)");
        }
        final State latestContent = SnapshotStateKt.rememberUpdatedState(function4, $composer, ($changed >> 3) & 14);
        final State latestKey = SnapshotStateKt.rememberUpdatedState(function1, $composer, ($changed >> 6) & 14);
        ComposerKt.sourceInformationMarkerStart($composer, 1578864961, "CC(remember):LazyLayoutPager.kt#9igjgp");
        boolean invalid$iv = (((($changed & 14) ^ 6) > 4 && $composer.changed(state)) || ($changed & 6) == 4) | $composer.changed(latestContent) | $composer.changed(latestKey) | (((($changed & 7168) ^ 3072) > 2048 && $composer.changed(function0)) || ($changed & 3072) == 2048);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            final State intervalContentState = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new Function0<PagerLayoutIntervalContent>() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$intervalContentState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final PagerLayoutIntervalContent invoke() {
                    return new PagerLayoutIntervalContent(latestContent.getValue(), latestKey.getValue(), function0.invoke().intValue());
                }
            });
            final State itemProviderState = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new Function0<PagerLazyLayoutItemProvider>() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$itemProviderState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final PagerLazyLayoutItemProvider invoke() {
                    PagerLayoutIntervalContent intervalContent = intervalContentState.getValue();
                    NearestRangeKeyIndexMap map = new NearestRangeKeyIndexMap(state.getNearestRange$foundation_release(), intervalContent);
                    return new PagerLazyLayoutItemProvider(state, intervalContent, map);
                }
            });
            value$iv = new PropertyReference0Impl(itemProviderState) { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$1
                @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return ((State) this.receiver).getValue();
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        KProperty0 kProperty0 = (KProperty0) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return kProperty0;
    }

    /* compiled from: LazyLayoutPager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1", f = "LazyLayoutPager.kt", i = {}, l = {284}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PagerState $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PagerState pagerState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = pagerState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$state, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: LazyLayoutPager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1", f = "LazyLayoutPager.kt", i = {}, l = {285}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $$this$pointerInput;
            final /* synthetic */ PagerState $state;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00351(PointerInputScope pointerInputScope, PagerState pagerState, Continuation<? super C00351> continuation) {
                super(2, continuation);
                this.$$this$pointerInput = pointerInputScope;
                this.$state = pagerState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00351(this.$$this$pointerInput, this.$state, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* compiled from: LazyLayoutPager.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1", f = "LazyLayoutPager.kt", i = {0, 1, 1, 1}, l = {287, 291}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "downEvent", "upEventOrCancellation"}, s = {"L$0", "L$0", "L$1", "L$2"})
            /* renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1, reason: invalid class name and collision with other inner class name */
            static final class C00361 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PagerState $state;
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00361(PagerState pagerState, Continuation<? super C00361> continuation) {
                    super(2, continuation);
                    this.$state = pagerState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00361 c00361 = new C00361(this.$state, continuation);
                    c00361.L$0 = obj;
                    return c00361;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((C00361) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Removed duplicated region for block: B:14:0x0075  */
                /* JADX WARN: Removed duplicated region for block: B:20:0x00a4  */
                /* JADX WARN: Removed duplicated region for block: B:26:0x00c2  */
                /* JADX WARN: Removed duplicated region for block: B:27:0x00d3  */
                /* JADX WARN: Removed duplicated region for block: B:28:0x00d8  */
                /* JADX WARN: Removed duplicated region for block: B:30:0x00be A[SYNTHETIC] */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x008a -> B:18:0x0092). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r22) {
                    /*
                        Method dump skipped, instructions count: 246
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.LazyLayoutPagerKt.AnonymousClass1.C00351.C00361.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (ForEachGestureKt.awaitEachGesture(this.$$this$pointerInput, new C00361(this.$state, null), this) != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                    this.label = 1;
                    if (CoroutineScopeKt.coroutineScope(new C00351($this$pointerInput, this.$state, null), this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    private static final Modifier dragDirectionDetector(Modifier $this$dragDirectionDetector, PagerState state) {
        return $this$dragDirectionDetector.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, state, new AnonymousClass1(state, null)));
    }
}
