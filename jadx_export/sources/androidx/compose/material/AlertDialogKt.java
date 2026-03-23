package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: AlertDialog.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a{\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a5\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a;\u0010\u001e\u001a\u00020\t*\u00020\u001f2\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010 \"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"TextBaselineDistanceFromTitle", "Landroidx/compose/ui/unit/TextUnit;", "J", "TextBaselineDistanceFromTop", "TextPadding", "Landroidx/compose/ui/Modifier;", "TitleBaselineDistanceFromTop", "TitlePadding", "AlertDialogContent", "", "buttons", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "AlertDialogContent-WMdw5o4", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/runtime/Composer;II)V", "AlertDialogFlowRow", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "AlertDialogBaselineLayout", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AlertDialogKt {
    private static final Modifier TitlePadding = PaddingKt.m685paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m6693constructorimpl(24), 0.0f, Dp.m6693constructorimpl(24), 0.0f, 10, null);
    private static final Modifier TextPadding = PaddingKt.m685paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m6693constructorimpl(24), 0.0f, Dp.m6693constructorimpl(24), Dp.m6693constructorimpl(28), 2, null);
    private static final long TitleBaselineDistanceFromTop = TextUnitKt.getSp(40);
    private static final long TextBaselineDistanceFromTitle = TextUnitKt.getSp(36);
    private static final long TextBaselineDistanceFromTop = TextUnitKt.getSp(38);

    /* renamed from: AlertDialogContent-WMdw5o4, reason: not valid java name */
    public static final void m1412AlertDialogContentWMdw5o4(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, long backgroundColor, long contentColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Function2 title;
        final Function2 text;
        Shape shape2;
        long backgroundColor2;
        long j;
        int i2;
        int $dirty;
        int $dirty2;
        long contentColor2;
        long backgroundColor3;
        Shape shape3;
        Modifier modifier3;
        Composer $composer2;
        final Function2 text2;
        final Modifier modifier4;
        final Shape shape4;
        final long contentColor3;
        final Function2 title2;
        final long backgroundColor4;
        Composer $composer3 = $composer.startRestartGroup(-453679601);
        ComposerKt.sourceInformation($composer3, "C(AlertDialogContent)P(1,3,6,5,4,0:c#ui.graphics.Color,2:c#ui.graphics.Color)50@1988L6,51@2046L6,52@2088L32,59@2266L911,54@2130L1047:AlertDialog.kt#jmzs0o");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty3 |= 384;
            title = function22;
        } else if (($changed & 384) == 0) {
            title = function22;
            $dirty3 |= $composer3.changedInstance(title) ? 256 : 128;
        } else {
            title = function22;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty3 |= 3072;
            text = function23;
        } else if (($changed & 3072) == 0) {
            text = function23;
            $dirty3 |= $composer3.changedInstance(text) ? 2048 : 1024;
        } else {
            text = function23;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                int i6 = $composer3.changed(shape2) ? 16384 : 8192;
                $dirty3 |= i6;
            } else {
                shape2 = shape;
            }
            $dirty3 |= i6;
        } else {
            shape2 = shape;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                backgroundColor2 = backgroundColor;
                int i7 = $composer3.changed(backgroundColor2) ? 131072 : 65536;
                $dirty3 |= i7;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty3 |= i7;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 64) == 0) {
                j = contentColor;
                i2 = 1572864;
                int i8 = $composer3.changed(j) ? 1048576 : 524288;
                $dirty3 |= i8;
            } else {
                j = contentColor;
                i2 = 1572864;
            }
            $dirty3 |= i8;
        } else {
            j = contentColor;
            i2 = 1572864;
        }
        int $dirty4 = $dirty3;
        if (($dirty3 & 599187) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            title2 = title;
            text2 = text;
            shape4 = shape2;
            backgroundColor4 = backgroundColor2;
            contentColor3 = j;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    title = null;
                }
                if (i5 != 0) {
                    text = null;
                }
                if ((i & 16) != 0) {
                    $dirty = $dirty4 & (-57345);
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getMedium();
                } else {
                    $dirty = $dirty4;
                }
                if ((i & 32) != 0) {
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1498getSurface0d7_KjU();
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty2 = $dirty & (-3670017);
                    contentColor2 = ColorsKt.m1512contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty >> 15) & 14);
                    backgroundColor3 = backgroundColor2;
                    shape3 = shape2;
                    modifier3 = modifier2;
                } else {
                    $dirty2 = $dirty;
                    contentColor2 = j;
                    backgroundColor3 = backgroundColor2;
                    shape3 = shape2;
                    modifier3 = modifier2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty4 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty4 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty2 = $dirty4 & (-3670017);
                    contentColor2 = j;
                    backgroundColor3 = backgroundColor2;
                    shape3 = shape2;
                    modifier3 = modifier2;
                } else {
                    $dirty2 = $dirty4;
                    contentColor2 = j;
                    backgroundColor3 = backgroundColor2;
                    shape3 = shape2;
                    modifier3 = modifier2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-453679601, $dirty2, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:53)");
            }
            $composer2 = $composer3;
            SurfaceKt.m1676SurfaceFjzlyU(modifier3, shape3, backgroundColor3, contentColor2, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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

                public final void invoke(Composer $composer4, int $changed2) {
                    Function0 factory$iv$iv$iv;
                    int $changed3;
                    ComposableLambda composableLambdaRememberComposableLambda;
                    Function2 function24;
                    ComposerKt.sourceInformation($composer4, "C60@2276L895:AlertDialog.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(629950291, $changed2, -1, "androidx.compose.material.AlertDialogContent.<anonymous> (AlertDialog.kt:60)");
                        }
                        final Function2<Composer, Integer, Unit> function25 = title;
                        final Function2<Composer, Integer, Unit> function26 = text;
                        Function2<Composer, Integer, Unit> function27 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer4.createNode(factory$iv$iv$iv);
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer4);
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                        }
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i9 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                        int $changed4 = ((0 >> 6) & 112) | 6;
                        ColumnScope $this$invoke_u24lambda_u242 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, -373579158, "C61@2297L842,81@3152L9:AlertDialog.kt#jmzs0o");
                        if (function25 == null) {
                            $composer4.startReplaceGroup(-373537744);
                            $composer4.endReplaceGroup();
                            $changed3 = $changed4;
                            composableLambdaRememberComposableLambda = null;
                        } else {
                            $composer4.startReplaceGroup(-373537743);
                            ComposerKt.sourceInformation($composer4, "*63@2393L288");
                            $changed3 = $changed4;
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                                public final void invoke(Composer $composer5, int $changed5) {
                                    ComposerKt.sourceInformation($composer5, "C64@2484L4,64@2490L169,64@2419L240:AlertDialog.kt#jmzs0o");
                                    if (($changed5 & 3) != 2 || !$composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(620104160, $changed5, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:64)");
                                        }
                                        ProvidedValue<Float> providedValueProvides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh($composer5, 6)));
                                        final Function2<Composer, Integer, Unit> function28 = function25;
                                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                            public final void invoke(Composer $composer6, int $changed6) {
                                                ComposerKt.sourceInformation($composer6, "C65@2550L10,66@2599L34:AlertDialog.kt#jmzs0o");
                                                if (($changed6 & 3) != 2 || !$composer6.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(770166432, $changed6, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:65)");
                                                    }
                                                    TextStyle textStyle = MaterialTheme.INSTANCE.getTypography($composer6, 6).getSubtitle1();
                                                    TextKt.ProvideTextStyle(textStyle, function28, $composer6, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer6.skipToGroupEnd();
                                            }
                                        }, $composer5, 54), $composer5, ProvidedValue.$stable | 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer5.skipToGroupEnd();
                                }
                            }, $composer4, 54);
                            $composer4.endReplaceGroup();
                        }
                        if (function26 == null) {
                            $composer4.startReplaceGroup(-373164163);
                            $composer4.endReplaceGroup();
                            function24 = null;
                        } else {
                            $composer4.startReplaceGroup(-373164162);
                            ComposerKt.sourceInformation($composer4, "*71@2768L339");
                            Function2 it = ComposableLambdaKt.rememberComposableLambda(1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                                public final void invoke(Composer $composer5, int $changed5) {
                                    ComposerKt.sourceInformation($composer5, "C73@2888L6,74@2921L164,72@2794L291:AlertDialog.kt#jmzs0o");
                                    if (($changed5 & 3) != 2 || !$composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1965858367, $changed5, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:72)");
                                        }
                                        ProvidedValue<Float> providedValueProvides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium($composer5, 6)));
                                        final Function2<Composer, Integer, Unit> function28 = function26;
                                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                            public final void invoke(Composer $composer6, int $changed6) {
                                                ComposerKt.sourceInformation($composer6, "C75@2981L10,76@3026L33:AlertDialog.kt#jmzs0o");
                                                if (($changed6 & 3) != 2 || !$composer6.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(2115920639, $changed6, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:75)");
                                                    }
                                                    TextStyle textStyle = MaterialTheme.INSTANCE.getTypography($composer6, 6).getBody2();
                                                    TextKt.ProvideTextStyle(textStyle, function28, $composer6, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer6.skipToGroupEnd();
                                            }
                                        }, $composer5, 54), $composer5, ProvidedValue.$stable | 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer5.skipToGroupEnd();
                                }
                            }, $composer4, 54);
                            function24 = it;
                            $composer4.endReplaceGroup();
                        }
                        AlertDialogKt.AlertDialogBaselineLayout($this$invoke_u24lambda_u242, composableLambdaRememberComposableLambda, function24, $composer4, $changed3 & 14);
                        function27.invoke($composer4, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer2, (($dirty2 >> 3) & 14) | i2 | (($dirty2 >> 9) & 112) | (($dirty2 >> 9) & 896) | (($dirty2 >> 9) & 7168), 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            text2 = text;
            modifier4 = modifier3;
            shape4 = shape3;
            contentColor3 = contentColor2;
            title2 = title;
            backgroundColor4 = backgroundColor3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$2
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

                public final void invoke(Composer composer, int i9) {
                    AlertDialogKt.m1412AlertDialogContentWMdw5o4(function2, modifier4, title2, text2, shape4, backgroundColor4, contentColor3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x040a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void AlertDialogBaselineLayout(final androidx.compose.foundation.layout.ColumnScope r53, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, androidx.compose.runtime.Composer r56, final int r57) {
        /*
            Method dump skipped, instructions count: 1054
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AlertDialogKt.AlertDialogBaselineLayout(androidx.compose.foundation.layout.ColumnScope, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    /* renamed from: AlertDialogFlowRow-ixp7dh8, reason: not valid java name */
    public static final void m1413AlertDialogFlowRowixp7dh8(final float mainAxisSpacing, final float crossAxisSpacing, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        MeasurePolicy value$iv;
        Composer $composer2 = $composer.startRestartGroup(73434452);
        ComposerKt.sourceInformation($composer2, "C(AlertDialogFlowRow)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp)194@7414L3565,194@7398L3581:AlertDialog.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(mainAxisSpacing) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(crossAxisSpacing) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(73434452, $dirty, -1, "androidx.compose.material.AlertDialogFlowRow (AlertDialog.kt:193)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 2008223483, "CC(remember):AlertDialog.kt#9igjgp");
            boolean invalid$iv = (($dirty & 14) == 4) | (($dirty & 112) == 32);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MeasurePolicy() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo34measure3p2s80s(final MeasureScope $this$Layout, List<? extends Measurable> list, long constraints) {
                        Ref.IntRef currentCrossAxisSize;
                        final int mainAxisLayoutSize;
                        long childConstraints;
                        final List sequences = new ArrayList();
                        List crossAxisSizes = new ArrayList();
                        final List crossAxisPositions = new ArrayList();
                        Ref.IntRef mainAxisSpace = new Ref.IntRef();
                        Ref.IntRef crossAxisSpace = new Ref.IntRef();
                        List currentSequence = new ArrayList();
                        Ref.IntRef currentMainAxisSize = new Ref.IntRef();
                        Ref.IntRef currentCrossAxisSize2 = new Ref.IntRef();
                        long childConstraints2 = ConstraintsKt.Constraints$default(0, Constraints.m6636getMaxWidthimpl(constraints), 0, 0, 13, null);
                        float f = mainAxisSpacing;
                        float f2 = crossAxisSpacing;
                        List $this$fastForEach$iv = list;
                        int index$iv = 0;
                        int size = $this$fastForEach$iv.size();
                        while (index$iv < size) {
                            Object item$iv = $this$fastForEach$iv.get(index$iv);
                            float f3 = f2;
                            Measurable measurable = (Measurable) item$iv;
                            Placeable placeable = measurable.mo5535measureBRTryo0(childConstraints2);
                            List $this$fastForEach$iv2 = $this$fastForEach$iv;
                            int index$iv2 = index$iv;
                            int i = size;
                            Ref.IntRef currentMainAxisSize2 = currentMainAxisSize;
                            List currentSequence2 = currentSequence;
                            if (measure_3p2s80s$canAddToCurrentSequence(currentSequence2, currentMainAxisSize2, $this$Layout, f, constraints, placeable)) {
                                childConstraints = childConstraints2;
                            } else {
                                childConstraints = childConstraints2;
                                measure_3p2s80s$startNewSequence(sequences, crossAxisSpace, $this$Layout, f3, currentSequence2, crossAxisSizes, currentCrossAxisSize2, crossAxisPositions, mainAxisSpace, currentMainAxisSize2);
                                currentSequence2 = currentSequence2;
                            }
                            if (!currentSequence2.isEmpty()) {
                                currentMainAxisSize2.element += $this$Layout.mo361roundToPx0680j_4(f);
                            }
                            currentSequence2.add(placeable);
                            currentMainAxisSize2.element += placeable.getWidth();
                            currentCrossAxisSize2.element = Math.max(currentCrossAxisSize2.element, placeable.getHeight());
                            index$iv = index$iv2 + 1;
                            currentSequence = currentSequence2;
                            currentMainAxisSize = currentMainAxisSize2;
                            childConstraints2 = childConstraints;
                            f2 = f3;
                            $this$fastForEach$iv = $this$fastForEach$iv2;
                            size = i;
                        }
                        Ref.IntRef currentMainAxisSize3 = currentMainAxisSize;
                        List currentSequence3 = currentSequence;
                        if (currentSequence3.isEmpty()) {
                            currentCrossAxisSize = crossAxisSpace;
                        } else {
                            measure_3p2s80s$startNewSequence(sequences, crossAxisSpace, $this$Layout, crossAxisSpacing, currentSequence3, crossAxisSizes, currentCrossAxisSize2, crossAxisPositions, mainAxisSpace, currentMainAxisSize3);
                            currentCrossAxisSize = crossAxisSpace;
                        }
                        if (Constraints.m6636getMaxWidthimpl(constraints) != Integer.MAX_VALUE) {
                            mainAxisLayoutSize = Constraints.m6636getMaxWidthimpl(constraints);
                        } else {
                            mainAxisLayoutSize = Math.max(mainAxisSpace.element, Constraints.m6638getMinWidthimpl(constraints));
                        }
                        int crossAxisLayoutSize = Math.max(currentCrossAxisSize.element, Constraints.m6637getMinHeightimpl(constraints));
                        int layoutWidth = mainAxisLayoutSize;
                        final float f4 = mainAxisSpacing;
                        return MeasureScope.CC.layout$default($this$Layout, layoutWidth, crossAxisLayoutSize, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope $this$layout) {
                                List $this$fastForEachIndexed$iv = sequences;
                                MeasureScope measureScope = $this$Layout;
                                float f5 = f4;
                                int i2 = mainAxisLayoutSize;
                                List<Integer> list2 = crossAxisPositions;
                                int index$iv3 = 0;
                                int size2 = $this$fastForEachIndexed$iv.size();
                                while (index$iv3 < size2) {
                                    Object item$iv2 = $this$fastForEachIndexed$iv.get(index$iv3);
                                    List placeables = (List) item$iv2;
                                    int i3 = index$iv3;
                                    int size3 = placeables.size();
                                    int[] childrenMainAxisSizes = new int[size3];
                                    int i4 = 0;
                                    while (i4 < size3) {
                                        childrenMainAxisSizes[i4] = placeables.get(i4).getWidth() + (i4 < CollectionsKt.getLastIndex(placeables) ? measureScope.mo361roundToPx0680j_4(f5) : 0);
                                        i4++;
                                    }
                                    Arrangement.Vertical arrangement = Arrangement.INSTANCE.getBottom();
                                    int length = childrenMainAxisSizes.length;
                                    int[] mainAxisPositions = new int[length];
                                    for (int i5 = 0; i5 < length; i5++) {
                                        mainAxisPositions[i5] = 0;
                                    }
                                    List $this$fastForEachIndexed$iv2 = $this$fastForEachIndexed$iv;
                                    arrangement.arrange(measureScope, i2, childrenMainAxisSizes, mainAxisPositions);
                                    int $i$f$fastForEachIndexed = placeables.size();
                                    for (int index$iv4 = 0; index$iv4 < $i$f$fastForEachIndexed; index$iv4++) {
                                        Object item$iv3 = placeables.get(index$iv4);
                                        Placeable placeable2 = (Placeable) item$iv3;
                                        int j = index$iv4;
                                        Placeable.PlacementScope.place$default($this$layout, placeable2, mainAxisPositions[j], list2.get(i3).intValue(), 0.0f, 4, null);
                                    }
                                    index$iv3++;
                                    $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv2;
                                }
                            }
                        }, 4, null);
                    }

                    private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, Ref.IntRef currentMainAxisSize, MeasureScope $this_Layout, float $mainAxisSpacing, long $constraints, Placeable placeable) {
                        return list.isEmpty() || (currentMainAxisSize.element + $this_Layout.mo361roundToPx0680j_4($mainAxisSpacing)) + placeable.getWidth() <= Constraints.m6636getMaxWidthimpl($constraints);
                    }

                    private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> list, Ref.IntRef crossAxisSpace, MeasureScope $this_Layout, float $crossAxisSpacing, List<Placeable> list2, List<Integer> list3, Ref.IntRef currentCrossAxisSize, List<Integer> list4, Ref.IntRef mainAxisSpace, Ref.IntRef currentMainAxisSize) {
                        if (!list.isEmpty()) {
                            crossAxisSpace.element += $this_Layout.mo361roundToPx0680j_4($crossAxisSpacing);
                        }
                        list.add(0, CollectionsKt.toList(list2));
                        list3.add(Integer.valueOf(currentCrossAxisSize.element));
                        list4.add(Integer.valueOf(crossAxisSpace.element));
                        crossAxisSpace.element += currentCrossAxisSize.element;
                        mainAxisSpace.element = Math.max(mainAxisSpace.element, currentMainAxisSize.element);
                        list2.clear();
                        currentMainAxisSize.element = 0;
                        currentCrossAxisSize.element = 0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MeasurePolicy measurePolicy$iv = (MeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed$iv = ($dirty >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.INSTANCE;
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv = (($changed$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3678constructorimpl($composer2);
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), block$iv$iv);
            }
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
            function2.invoke($composer2, Integer.valueOf(($changed$iv$iv >> 6) & 14));
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$2
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

                public final void invoke(Composer composer, int i) {
                    AlertDialogKt.m1413AlertDialogFlowRowixp7dh8(mainAxisSpacing, crossAxisSpacing, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
