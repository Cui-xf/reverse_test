package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Layout.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a8\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0087\b¢\u0006\u0002\u0010\f\u001a \u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0087\b¢\u0006\u0002\u0010\r\u001a>\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u00070\u000f2\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0010H\u0087\b¢\u0006\u0002\u0010\u0011\u001a7\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0013\u001a;\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u00072\u001c\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u00070\u000fH\u0001¢\u0006\u0002\u0010\u0015\u001a3\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0004\u0012\u00020\u00030\u0017¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u001a2\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a3\u0010\u001d\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0004\u0012\u00020\u00030\u0017¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u001a2\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0016\u0010\u001c\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"LargeDimension", "", "Layout", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "contents", "", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MultiContentMeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "MultiMeasureLayout", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "combineAsVirtualLayouts", "(Ljava/util/List;)Lkotlin/jvm/functions/Function2;", "materializerOf", "Lkotlin/Function1;", "Landroidx/compose/runtime/SkippableUpdater;", "Landroidx/compose/ui/node/ComposeUiNode;", "Lkotlin/ExtensionFunctionType;", "modifierMaterializerOf", "(Landroidx/compose/ui/Modifier;)Lkotlin/jvm/functions/Function3;", "materializerOfWithCompositionLocalInjection", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutKt {
    public static final int LargeDimension = 32767;

    public static final void Layout(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, MeasurePolicy measurePolicy, Composer $composer, int $changed, int i) {
        Modifier.Companion modifier2;
        ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        if ((i & 2) != 0) {
            modifier2 = Modifier.INSTANCE;
        } else {
            modifier2 = modifier;
        }
        int compositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
        CompositionLocalMap localMap = $composer.getCurrentCompositionLocalMap();
        Modifier materialized = ComposedModifierKt.materializeModifier($composer, modifier2);
        Function0 factory$iv = ComposeUiNode.INSTANCE.getConstructor();
        int $changed$iv = (($changed << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            $composer.createNode(factory$iv);
        } else {
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240 = Updater.m3678constructorimpl($composer);
        Updater.m3685setimpl($this$Layout_u24lambda_u240, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3685setimpl($this$Layout_u24lambda_u240, localMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2 block$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if ($this$Layout_u24lambda_u240.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240.rememberedValue(), Integer.valueOf(compositeKeyHash))) {
            $this$Layout_u24lambda_u240.updateRememberedValue(Integer.valueOf(compositeKeyHash));
            $this$Layout_u24lambda_u240.apply(Integer.valueOf(compositeKeyHash), block$iv);
        }
        Updater.m3685setimpl($this$Layout_u24lambda_u240, materialized, ComposeUiNode.INSTANCE.getSetModifier());
        function2.invoke($composer, Integer.valueOf(($changed$iv >> 6) & 14));
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final void Layout(Modifier modifier, MeasurePolicy measurePolicy, Composer $composer, int $changed, int i) {
        Modifier.Companion modifier2;
        ComposerKt.sourceInformationMarkerStart($composer, 544976794, "CC(Layout)P(1)124@4836L23,127@4987L385:Layout.kt#80mrfh");
        if ((i & 1) != 0) {
            modifier2 = Modifier.INSTANCE;
        } else {
            modifier2 = modifier;
        }
        int compositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
        Modifier materialized = ComposedModifierKt.materializeModifier($composer, modifier2);
        CompositionLocalMap localMap = $composer.getCurrentCompositionLocalMap();
        Function0 factory$iv = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart($composer, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            $composer.createNode(factory$iv);
        } else {
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u241 = Updater.m3678constructorimpl($composer);
        Updater.m3685setimpl($this$Layout_u24lambda_u241, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3685setimpl($this$Layout_u24lambda_u241, localMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m3685setimpl($this$Layout_u24lambda_u241, materialized, ComposeUiNode.INSTANCE.getSetModifier());
        Function2 block$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if ($this$Layout_u24lambda_u241.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u241.rememberedValue(), Integer.valueOf(compositeKeyHash))) {
            $this$Layout_u24lambda_u241.updateRememberedValue(Integer.valueOf(compositeKeyHash));
            $this$Layout_u24lambda_u241.apply(Integer.valueOf(compositeKeyHash), block$iv);
        }
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003c A[PHI: r5
      0x003c: PHI (r5v9 androidx.compose.ui.layout.MultiContentMeasurePolicy) = 
      (r5v4 androidx.compose.ui.layout.MultiContentMeasurePolicy)
      (r5v10 androidx.compose.ui.layout.MultiContentMeasurePolicy)
     binds: [B:13:0x003a, B:9:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Layout(java.util.List<? extends kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>> r20, androidx.compose.ui.Modifier r21, androidx.compose.ui.layout.MultiContentMeasurePolicy r22, androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutKt.Layout(java.util.List, androidx.compose.ui.Modifier, androidx.compose.ui.layout.MultiContentMeasurePolicy, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final Function2<Composer, Integer, Unit> combineAsVirtualLayouts(final List<? extends Function2<? super Composer, ? super Integer, Unit>> list) {
        return ComposableLambdaKt.composableLambdaInstance(-1953651383, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LayoutKt.combineAsVirtualLayouts.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer, int $changed) {
                List $this$fastForEach$iv;
                ComposerKt.sourceInformation($composer, "C*182@7270L23,183@7302L298:Layout.kt#80mrfh");
                if (($changed & 3) != 2 || !$composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1953651383, $changed, -1, "androidx.compose.ui.layout.combineAsVirtualLayouts.<anonymous> (Layout.kt:181)");
                    }
                    List $this$fastForEach$iv2 = list;
                    int index$iv = 0;
                    int size = $this$fastForEach$iv2.size();
                    while (index$iv < size) {
                        Object item$iv = $this$fastForEach$iv2.get(index$iv);
                        Function2 content = (Function2) item$iv;
                        int compositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                        Function0 factory$iv = ComposeUiNode.INSTANCE.getVirtualConstructor();
                        ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                            $composer.createNode(factory$iv);
                        } else {
                            $composer.useNode();
                        }
                        Composer $this$invoke_u24lambda_u241_u24lambda_u240 = Updater.m3678constructorimpl($composer);
                        Function2 block$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$invoke_u24lambda_u241_u24lambda_u240.getInserting()) {
                            $this$fastForEach$iv = $this$fastForEach$iv2;
                        } else {
                            $this$fastForEach$iv = $this$fastForEach$iv2;
                            if (!Intrinsics.areEqual($this$invoke_u24lambda_u241_u24lambda_u240.rememberedValue(), Integer.valueOf(compositeKeyHash))) {
                            }
                            content.invoke($composer, Integer.valueOf((6 >> 6) & 14));
                            $composer.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            index$iv++;
                            $this$fastForEach$iv2 = $this$fastForEach$iv;
                        }
                        $this$invoke_u24lambda_u241_u24lambda_u240.updateRememberedValue(Integer.valueOf(compositeKeyHash));
                        $this$invoke_u24lambda_u241_u24lambda_u240.apply(Integer.valueOf(compositeKeyHash), block$iv);
                        content.invoke($composer, Integer.valueOf((6 >> 6) & 14));
                        $composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        index$iv++;
                        $this$fastForEach$iv2 = $this$fastForEach$iv;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        });
    }

    public static final Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf(final Modifier modifier) {
        return ComposableLambdaKt.composableLambdaInstance(-1586257396, true, new Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LayoutKt.materializerOf.1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SkippableUpdater<ComposeUiNode> skippableUpdater, Composer composer, Integer num) {
                m5564invokeDeg8D_g(skippableUpdater.getComposer(), composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-Deg8D_g, reason: not valid java name */
            public final void m5564invokeDeg8D_g(Composer $this$null, Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "C204@8054L23:Layout.kt#80mrfh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1586257396, $changed, -1, "androidx.compose.ui.layout.materializerOf.<anonymous> (Layout.kt:204)");
                }
                int compositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                Modifier materialized = ComposedModifierKt.materializeModifier($composer, modifier);
                $this$null.startReplaceableGroup(509942095);
                Composer $this$invoke_Deg8D_g_u24lambda_u240 = Updater.m3678constructorimpl($this$null);
                Updater.m3685setimpl($this$invoke_Deg8D_g_u24lambda_u240, materialized, ComposeUiNode.INSTANCE.getSetModifier());
                Function2 block$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$invoke_Deg8D_g_u24lambda_u240.getInserting() || !Intrinsics.areEqual($this$invoke_Deg8D_g_u24lambda_u240.rememberedValue(), Integer.valueOf(compositeKeyHash))) {
                    $this$invoke_Deg8D_g_u24lambda_u240.updateRememberedValue(Integer.valueOf(compositeKeyHash));
                    $this$invoke_Deg8D_g_u24lambda_u240.apply(Integer.valueOf(compositeKeyHash), block$iv);
                }
                $this$null.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Needed only for backwards compatibility. Do not use.")
    public static final Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf(final Modifier modifier) {
        return ComposableLambdaKt.composableLambdaInstance(-55743822, true, new Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LayoutKt$materializerOfWithCompositionLocalInjection$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SkippableUpdater<ComposeUiNode> skippableUpdater, Composer composer, Integer num) {
                m5565invokeDeg8D_g(skippableUpdater.getComposer(), composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-Deg8D_g, reason: not valid java name */
            public final void m5565invokeDeg8D_g(Composer $this$null, Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "C227@8894L23:Layout.kt#80mrfh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-55743822, $changed, -1, "androidx.compose.ui.layout.materializerOfWithCompositionLocalInjection.<anonymous> (Layout.kt:227)");
                }
                int compositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                Modifier materialized = ComposedModifierKt.materializeWithCompositionLocalInjectionInternal($composer, modifier);
                $this$null.startReplaceableGroup(509942095);
                Composer $this$invoke_Deg8D_g_u24lambda_u240 = Updater.m3678constructorimpl($this$null);
                Updater.m3685setimpl($this$invoke_Deg8D_g_u24lambda_u240, materialized, ComposeUiNode.INSTANCE.getSetModifier());
                Function2 block$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$invoke_Deg8D_g_u24lambda_u240.getInserting() || !Intrinsics.areEqual($this$invoke_Deg8D_g_u24lambda_u240.rememberedValue(), Integer.valueOf(compositeKeyHash))) {
                    $this$invoke_Deg8D_g_u24lambda_u240.updateRememberedValue(Integer.valueOf(compositeKeyHash));
                    $this$invoke_Deg8D_g_u24lambda_u240.apply(Integer.valueOf(compositeKeyHash), block$iv);
                }
                $this$null.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0146  */
    @kotlin.Deprecated(message = "This API is unsafe for UI performance at scale - using it incorrectly will lead to exponential performance issues. This API should be avoided whenever possible.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void MultiMeasureLayout(androidx.compose.ui.Modifier r18, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r19, final androidx.compose.ui.layout.MeasurePolicy r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutKt.MultiMeasureLayout(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.layout.MeasurePolicy, androidx.compose.runtime.Composer, int, int):void");
    }
}
