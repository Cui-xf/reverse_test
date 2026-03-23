package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppBar.kt */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aj\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001av\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001an\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u008c\u0001\u0010$\u001a\u00020\f2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\f0&¢\u0006\u0002\b\u001a2\u0006\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010&¢\u0006\u0002\b\u001a2\u001e\b\u0002\u0010(\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u0084\u0001\u0010$\u001a\u00020\f2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\f0&¢\u0006\u0002\b\u001a2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010&¢\u0006\u0002\b\u001a2\u001e\b\u0002\u0010(\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001aj\u0010$\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001ab\u0010$\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a\u0019\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u000202H\u0080\b\u001a,\u00105\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000202062\u0006\u00107\u001a\u0002022\u0006\u00104\u001a\u0002022\u0006\u00108\u001a\u000202H\u0000\u001a\u0011\u00109\u001a\u0002022\u0006\u0010:\u001a\u000202H\u0082\b\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006;"}, d2 = {"AppBarHeight", "Landroidx/compose/ui/unit/Dp;", "F", "AppBarHorizontalPadding", "BottomAppBarCutoutOffset", "BottomAppBarRoundedEdgeRadius", "TitleIconModifier", "Landroidx/compose/ui/Modifier;", "TitleInsetWithoutIcon", "ZeroInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "AppBar", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "shape", "Landroidx/compose/ui/graphics/Shape;", "windowInsets", "modifier", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "AppBar-HkEspTQ", "(JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar", "cutoutShape", "BottomAppBar-DanWW-k", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar-Y1yfwus", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TopAppBar", "title", "Lkotlin/Function0;", "navigationIcon", "actions", "TopAppBar-Rx1qByU", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJFLandroidx/compose/runtime/Composer;II)V", "TopAppBar-xWeB9-s", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJFLandroidx/compose/runtime/Composer;II)V", "TopAppBar-afqeVBk", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TopAppBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "calculateCutoutCircleYIntercept", "", "cutoutRadius", "verticalOffset", "calculateRoundedEdgeIntercept", "Lkotlin/Pair;", "controlPointX", "radius", "square", "x", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppBarKt {
    private static final float AppBarHeight = Dp.m6693constructorimpl(56);
    private static final float AppBarHorizontalPadding = Dp.m6693constructorimpl(4);
    private static final float BottomAppBarCutoutOffset;
    private static final float BottomAppBarRoundedEdgeRadius;
    private static final Modifier TitleIconModifier;
    private static final Modifier TitleInsetWithoutIcon;
    private static final WindowInsets ZeroInsets;

    /* renamed from: TopAppBar-Rx1qByU, reason: not valid java name */
    public static final void m1424TopAppBarRx1qByU(Function2<? super Composer, ? super Integer, Unit> function2, final WindowInsets windowInsets, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, long backgroundColor, long contentColor, float elevation, Composer $composer, final int $changed, final int i) {
        WindowInsets windowInsets2;
        Modifier modifier2;
        final Function2 navigationIcon;
        final Function3 actions;
        long backgroundColor2;
        long contentColor2;
        Modifier modifier3;
        long contentColor3;
        float elevation2;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        Composer $composer2;
        final Function2 navigationIcon2;
        final Function3 actions2;
        final long backgroundColor3;
        final long contentColor4;
        final float elevation3;
        final Modifier modifier4;
        Composer $composer3 = $composer.startRestartGroup(-763778507);
        ComposerKt.sourceInformation($composer3, "C(TopAppBar)P(6,7,4,5!1,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)90@4376L6,91@4425L32,102@4704L1128,94@4522L1310:AppBar.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
            windowInsets2 = windowInsets;
        } else if (($changed & 48) == 0) {
            windowInsets2 = windowInsets;
            $dirty |= $composer3.changed(windowInsets2) ? 32 : 16;
        } else {
            windowInsets2 = windowInsets;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            navigationIcon = function22;
        } else if (($changed & 3072) == 0) {
            navigationIcon = function22;
            $dirty |= $composer3.changedInstance(navigationIcon) ? 2048 : 1024;
        } else {
            navigationIcon = function22;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            actions = function3;
        } else if (($changed & 24576) == 0) {
            actions = function3;
            $dirty |= $composer3.changedInstance(actions) ? 16384 : 8192;
        } else {
            actions = function3;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                backgroundColor2 = backgroundColor;
                int i5 = $composer3.changed(backgroundColor2) ? 131072 : 65536;
                $dirty |= i5;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty |= i5;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= ((i & 64) == 0 && $composer3.changed(contentColor)) ? 1048576 : 524288;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changed(elevation) ? 8388608 : 4194304;
        }
        if ((4793491 & $dirty) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier2;
            backgroundColor3 = backgroundColor2;
            function23 = function2;
            $composer2 = $composer3;
            navigationIcon2 = navigationIcon;
            actions2 = actions;
            contentColor4 = contentColor;
            elevation3 = elevation;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i3 != 0) {
                    navigationIcon = null;
                }
                if (i4 != 0) {
                    actions = ComposableSingletons$AppBarKt.INSTANCE.m1518getLambda1$material_release();
                }
                if ((i & 32) != 0) {
                    backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer3, 6));
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    contentColor2 = ColorsKt.m1512contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty >> 15) & 14);
                    $dirty &= -3670017;
                } else {
                    contentColor2 = contentColor;
                }
                if (i6 != 0) {
                    modifier3 = modifier2;
                    contentColor3 = contentColor2;
                    elevation2 = AppBarDefaults.INSTANCE.m1419getTopAppBarElevationD9Ej5fM();
                } else {
                    modifier3 = modifier2;
                    contentColor3 = contentColor2;
                    elevation2 = elevation;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    contentColor3 = contentColor;
                    elevation2 = elevation;
                    $dirty &= -3670017;
                    modifier3 = modifier2;
                } else {
                    contentColor3 = contentColor;
                    elevation2 = elevation;
                    modifier3 = modifier2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-763778507, $dirty, -1, "androidx.compose.material.TopAppBar (AppBar.kt:93)");
            }
            function23 = function2;
            $composer2 = $composer3;
            m1420AppBarHkEspTQ(backgroundColor2, contentColor3, elevation2, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), windowInsets2, modifier3, ComposableLambdaKt.rememberComposableLambda(1849684359, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                    invoke(rowScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope $this$AppBar, Composer $composer4, int $changed2) {
                    Function0 factory$iv$iv$iv;
                    Function0 factory$iv$iv$iv2;
                    ComposerKt.sourceInformation($composer4, "C114@5092L412,128@5579L6,128@5587L239,128@5514L312:AppBar.kt#jmzs0o");
                    int $dirty2 = $changed2;
                    if (($changed2 & 6) == 0) {
                        $dirty2 |= $composer4.changed($this$AppBar) ? 4 : 2;
                    }
                    if (($dirty2 & 19) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1849684359, $dirty2, -1, "androidx.compose.material.TopAppBar.<anonymous> (AppBar.kt:103)");
                        }
                        if (navigationIcon == null) {
                            $composer4.startReplaceGroup(1108907693);
                            ComposerKt.sourceInformation($composer4, "104@4756L29");
                            SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, $composer4, 6);
                            $composer4.endReplaceGroup();
                        } else {
                            $composer4.startReplaceGroup(1108973289);
                            ComposerKt.sourceInformation($composer4, "106@4815L257");
                            Modifier modifier$iv = AppBarKt.TitleIconModifier;
                            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                            Function2<Composer, Integer, Unit> function24 = navigationIcon;
                            ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                            int $changed$iv$iv = (390 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                            Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                factory$iv$iv$iv = factory$iv$iv$iv3;
                                $composer4.createNode(factory$iv$iv$iv);
                            } else {
                                factory$iv$iv$iv = factory$iv$iv$iv3;
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
                            int i7 = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            int i8 = ((390 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, 1098159242, "C108@4990L4,107@4904L154:AppBar.kt#jmzs0o");
                            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh($composer4, 6))), function24, $composer4, ProvidedValue.$stable);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endReplaceGroup();
                        }
                        Modifier modifier$iv2 = RowScope.CC.weight$default($this$AppBar, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                        Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getCenterVertically();
                        final Function2<Composer, Integer, Unit> function25 = function23;
                        ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv2 = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                        Function0 factory$iv$iv$iv4 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            factory$iv$iv$iv2 = factory$iv$iv$iv4;
                            $composer4.createNode(factory$iv$iv$iv2);
                        } else {
                            factory$iv$iv$iv2 = factory$iv$iv$iv4;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3678constructorimpl($composer4);
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), block$iv$iv$iv2);
                        }
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i9 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        int i10 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1098517757, "C120@5302L10,120@5317L177,120@5263L231:AppBar.kt#jmzs0o");
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography($composer4, 6).getH6(), ComposableLambdaKt.rememberComposableLambda(-1654084516, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C122@5421L4,121@5335L145:AppBar.kt#jmzs0o");
                                if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1654084516, $changed3, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous>.<anonymous> (AppBar.kt:121)");
                                    }
                                    CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh($composer5, 6))), function25, $composer5, ProvidedValue.$stable);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54), $composer4, 48);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ProvidedValue<Float> providedValueProvides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium($composer4, 6)));
                        final Function3<RowScope, Composer, Integer, Unit> function32 = actions;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(2129753671, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C129@5601L215:AppBar.kt#jmzs0o");
                                if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2129753671, $changed3, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous> (AppBar.kt:129)");
                                    }
                                    Modifier modifier$iv3 = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getEnd();
                                    Alignment.Vertical verticalAlignment$iv3 = Alignment.INSTANCE.getCenterVertically();
                                    Function3 content$iv = function32;
                                    ComposerKt.sourceInformationMarkerStart($composer5, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                    MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer5, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                                    int $changed$iv$iv3 = (438 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                    CompositionLocalMap localMap$iv$iv3 = $composer5.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer5, modifier$iv3);
                                    Function0 factory$iv$iv$iv5 = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!($composer5.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer5.startReusableNode();
                                    if ($composer5.getInserting()) {
                                        $composer5.createNode(factory$iv$iv$iv5);
                                    } else {
                                        $composer5.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3678constructorimpl($composer5);
                                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2 block$iv$iv$iv3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                        $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                        $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), block$iv$iv$iv3);
                                    }
                                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i11 = ($changed$iv$iv$iv3 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                                    content$iv.invoke(RowScopeInstance.INSTANCE, $composer5, Integer.valueOf(((438 >> 6) & 112) | 6));
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    $composer5.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54), $composer4, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer2, (($dirty >> 15) & 14) | 12610560 | (($dirty >> 15) & 112) | (($dirty >> 15) & 896) | (($dirty << 12) & 458752) | (3670016 & ($dirty << 12)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            navigationIcon2 = navigationIcon;
            actions2 = actions;
            backgroundColor3 = backgroundColor2;
            contentColor4 = contentColor3;
            elevation3 = elevation2;
            modifier4 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$2
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

                public final void invoke(Composer composer, int i7) {
                    AppBarKt.m1424TopAppBarRx1qByU(function23, windowInsets, modifier4, navigationIcon2, actions2, backgroundColor3, contentColor4, elevation3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: TopAppBar-xWeB9-s, reason: not valid java name */
    public static final void m1426TopAppBarxWeB9s(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, long backgroundColor, long contentColor, float elevation, Composer $composer, final int $changed, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function23;
        Modifier modifier2;
        Function2 navigationIcon;
        Function3 actions;
        long backgroundColor2;
        long contentColor2;
        int $dirty;
        float elevation2;
        int $dirty2;
        long backgroundColor3;
        long contentColor3;
        int $dirty3;
        Modifier modifier3;
        Function2 navigationIcon2;
        Function3 actions2;
        Composer $composer2;
        final Modifier modifier4;
        final Function2 navigationIcon3;
        final Function3 actions3;
        final long backgroundColor4;
        final long contentColor4;
        final float elevation3;
        Composer $composer3 = $composer.startRestartGroup(-2087748139);
        ComposerKt.sourceInformation($composer3, "C(TopAppBar)P(6,4,5!1,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)172@7722L6,173@7771L32,176@7867L175:AppBar.kt#jmzs0o");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
            function23 = function2;
        } else if (($changed & 6) == 0) {
            function23 = function2;
            $dirty4 |= $composer3.changedInstance(function23) ? 4 : 2;
        } else {
            function23 = function2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty4 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty4 |= 384;
            navigationIcon = function22;
        } else if (($changed & 384) == 0) {
            navigationIcon = function22;
            $dirty4 |= $composer3.changedInstance(navigationIcon) ? 256 : 128;
        } else {
            navigationIcon = function22;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty4 |= 3072;
            actions = function3;
        } else if (($changed & 3072) == 0) {
            actions = function3;
            $dirty4 |= $composer3.changedInstance(actions) ? 2048 : 1024;
        } else {
            actions = function3;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                backgroundColor2 = backgroundColor;
                int i5 = $composer3.changed(backgroundColor2) ? 16384 : 8192;
                $dirty4 |= i5;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty4 |= i5;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                contentColor2 = contentColor;
                int i6 = $composer3.changed(contentColor2) ? 131072 : 65536;
                $dirty4 |= i6;
            } else {
                contentColor2 = contentColor;
            }
            $dirty4 |= i6;
        } else {
            contentColor2 = contentColor;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty4 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty4 |= $composer3.changed(elevation) ? 1048576 : 524288;
        }
        int $dirty5 = $dirty4;
        if (($dirty4 & 599187) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            elevation3 = elevation;
            $composer2 = $composer3;
            modifier4 = modifier2;
            navigationIcon3 = navigationIcon;
            actions3 = actions;
            backgroundColor4 = backgroundColor2;
            contentColor4 = contentColor2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i3 != 0) {
                    navigationIcon = null;
                }
                if (i4 != 0) {
                    actions = ComposableSingletons$AppBarKt.INSTANCE.m1519getLambda2$material_release();
                }
                if ((i & 16) != 0) {
                    backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer3, 6));
                    $dirty = $dirty5 & (-57345);
                } else {
                    $dirty = $dirty5;
                }
                if ((i & 32) != 0) {
                    contentColor2 = ColorsKt.m1512contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty >> 12) & 14);
                    $dirty &= -458753;
                }
                if (i7 != 0) {
                    elevation2 = AppBarDefaults.INSTANCE.m1419getTopAppBarElevationD9Ej5fM();
                    backgroundColor3 = backgroundColor2;
                    contentColor3 = contentColor2;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                    navigationIcon2 = navigationIcon;
                    actions2 = actions;
                    $dirty3 = -2087748139;
                } else {
                    elevation2 = elevation;
                    $dirty2 = $dirty;
                    backgroundColor3 = backgroundColor2;
                    contentColor3 = contentColor2;
                    $dirty3 = -2087748139;
                    modifier3 = modifier2;
                    navigationIcon2 = navigationIcon;
                    actions2 = actions;
                }
            } else {
                $composer3.skipToGroupEnd();
                int $dirty6 = (i & 16) != 0 ? $dirty5 & (-57345) : $dirty5;
                if ((i & 32) != 0) {
                    $dirty6 &= -458753;
                }
                elevation2 = elevation;
                $dirty2 = $dirty6;
                backgroundColor3 = backgroundColor2;
                contentColor3 = contentColor2;
                $dirty3 = -2087748139;
                modifier3 = modifier2;
                navigationIcon2 = navigationIcon;
                actions2 = actions;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart($dirty3, $dirty2, -1, "androidx.compose.material.TopAppBar (AppBar.kt:175)");
            }
            $composer2 = $composer3;
            m1424TopAppBarRx1qByU(function23, ZeroInsets, modifier3, navigationIcon2, actions2, backgroundColor3, contentColor3, elevation2, $composer2, ($dirty2 & 14) | 48 | (($dirty2 << 3) & 896) | (($dirty2 << 3) & 7168) | (($dirty2 << 3) & 57344) | (($dirty2 << 3) & 458752) | (($dirty2 << 3) & 3670016) | (29360128 & ($dirty2 << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            navigationIcon3 = navigationIcon2;
            actions3 = actions2;
            backgroundColor4 = backgroundColor3;
            contentColor4 = contentColor3;
            elevation3 = elevation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$3
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

                public final void invoke(Composer composer, int i8) {
                    AppBarKt.m1426TopAppBarxWeB9s(function2, modifier4, navigationIcon3, actions3, backgroundColor4, contentColor4, elevation3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: TopAppBar-afqeVBk, reason: not valid java name */
    public static final void m1425TopAppBarafqeVBk(final WindowInsets windowInsets, Modifier modifier, long backgroundColor, long contentColor, float elevation, PaddingValues contentPadding, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long backgroundColor2;
        long contentColor2;
        float elevation2;
        PaddingValues paddingValues;
        Modifier modifier3;
        float elevation3;
        PaddingValues contentPadding2;
        long backgroundColor3;
        long contentColor3;
        Composer $composer2;
        final long backgroundColor4;
        final long contentColor4;
        final float elevation4;
        final PaddingValues contentPadding3;
        final Modifier modifier4;
        Composer $composer3 = $composer.startRestartGroup(883764366);
        ComposerKt.sourceInformation($composer3, "C(TopAppBar)P(6,5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3)222@9964L6,223@10013L32,228@10222L204:AppBar.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(windowInsets) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                backgroundColor2 = backgroundColor;
                int i3 = $composer3.changed(backgroundColor2) ? 256 : 128;
                $dirty |= i3;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty |= i3;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i4 = $composer3.changed(contentColor2) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i4;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
            elevation2 = elevation;
        } else if (($changed & 24576) == 0) {
            elevation2 = elevation;
            $dirty |= $composer3.changed(elevation2) ? 16384 : 8192;
        } else {
            elevation2 = elevation;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            paddingValues = contentPadding;
        } else if ((196608 & $changed) == 0) {
            paddingValues = contentPadding;
            $dirty |= $composer3.changed(paddingValues) ? 131072 : 65536;
        } else {
            paddingValues = contentPadding;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 1048576 : 524288;
        }
        if (($dirty & 599187) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            backgroundColor4 = backgroundColor2;
            elevation4 = elevation2;
            modifier4 = modifier2;
            contentColor4 = contentColor2;
            contentPadding3 = paddingValues;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer3, 6));
                }
                if ((i & 8) != 0) {
                    long contentColor5 = ColorsKt.m1512contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty >> 6) & 14);
                    $dirty &= -7169;
                    contentColor2 = contentColor5;
                }
                if (i5 != 0) {
                    elevation2 = AppBarDefaults.INSTANCE.m1419getTopAppBarElevationD9Ej5fM();
                }
                if (i6 != 0) {
                    contentPadding2 = AppBarDefaults.INSTANCE.getContentPadding();
                    modifier3 = modifier2;
                    contentColor3 = contentColor2;
                    elevation3 = elevation2;
                    backgroundColor3 = backgroundColor2;
                } else {
                    modifier3 = modifier2;
                    elevation3 = elevation2;
                    contentPadding2 = paddingValues;
                    backgroundColor3 = backgroundColor2;
                    contentColor3 = contentColor2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    modifier3 = modifier2;
                    elevation3 = elevation2;
                    contentPadding2 = paddingValues;
                    backgroundColor3 = backgroundColor2;
                    contentColor3 = contentColor2;
                } else {
                    modifier3 = modifier2;
                    elevation3 = elevation2;
                    contentPadding2 = paddingValues;
                    backgroundColor3 = backgroundColor2;
                    contentColor3 = contentColor2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(883764366, $dirty, -1, "androidx.compose.material.TopAppBar (AppBar.kt:227)");
            }
            $composer2 = $composer3;
            m1420AppBarHkEspTQ(backgroundColor3, contentColor3, elevation3, contentPadding2, RectangleShapeKt.getRectangleShape(), windowInsets, modifier3, function3, $composer2, (($dirty >> 6) & 14) | 24576 | (($dirty >> 6) & 112) | (($dirty >> 6) & 896) | (($dirty >> 6) & 7168) | (($dirty << 15) & 458752) | (3670016 & ($dirty << 15)) | (($dirty << 3) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            backgroundColor4 = backgroundColor3;
            contentColor4 = contentColor3;
            elevation4 = elevation3;
            contentPadding3 = contentPadding2;
            modifier4 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$4
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

                public final void invoke(Composer composer, int i7) {
                    AppBarKt.m1425TopAppBarafqeVBk(windowInsets, modifier4, backgroundColor4, contentColor4, elevation4, contentPadding3, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: TopAppBar-HsRjFd4, reason: not valid java name */
    public static final void m1423TopAppBarHsRjFd4(Modifier modifier, long backgroundColor, long contentColor, float elevation, PaddingValues contentPadding, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long backgroundColor2;
        long contentColor2;
        float elevation2;
        PaddingValues paddingValues;
        Modifier modifier3;
        float elevation3;
        PaddingValues contentPadding2;
        long backgroundColor3;
        long contentColor3;
        Composer $composer2;
        final long backgroundColor4;
        final long contentColor4;
        final float elevation4;
        final PaddingValues contentPadding3;
        final Modifier modifier4;
        Composer $composer3 = $composer.startRestartGroup(1897058582);
        ComposerKt.sourceInformation($composer3, "C(TopAppBar)P(5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3)269@12098L6,270@12147L32,275@12356L202:AppBar.kt#jmzs0o");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                backgroundColor2 = backgroundColor;
                int i3 = $composer3.changed(backgroundColor2) ? 32 : 16;
                $dirty |= i3;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty |= i3;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                contentColor2 = contentColor;
                int i4 = $composer3.changed(contentColor2) ? 256 : 128;
                $dirty |= i4;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i4;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            elevation2 = elevation;
        } else if (($changed & 3072) == 0) {
            elevation2 = elevation;
            $dirty |= $composer3.changed(elevation2) ? 2048 : 1024;
        } else {
            elevation2 = elevation;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            paddingValues = contentPadding;
        } else if (($changed & 24576) == 0) {
            paddingValues = contentPadding;
            $dirty |= $composer3.changed(paddingValues) ? 16384 : 8192;
        } else {
            paddingValues = contentPadding;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 131072 : 65536;
        }
        if ((74899 & $dirty) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            backgroundColor4 = backgroundColor2;
            elevation4 = elevation2;
            $composer2 = $composer3;
            modifier4 = modifier2;
            contentColor4 = contentColor2;
            contentPadding3 = paddingValues;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    $dirty &= -113;
                    backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer3, 6));
                }
                if ((i & 4) != 0) {
                    long contentColor5 = ColorsKt.m1512contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty >> 3) & 14);
                    $dirty &= -897;
                    contentColor2 = contentColor5;
                }
                if (i5 != 0) {
                    elevation2 = AppBarDefaults.INSTANCE.m1419getTopAppBarElevationD9Ej5fM();
                }
                if (i6 != 0) {
                    modifier3 = modifier5;
                    contentPadding2 = AppBarDefaults.INSTANCE.getContentPadding();
                    contentColor3 = contentColor2;
                    elevation3 = elevation2;
                    backgroundColor3 = backgroundColor2;
                } else {
                    modifier3 = modifier5;
                    elevation3 = elevation2;
                    contentPadding2 = paddingValues;
                    backgroundColor3 = backgroundColor2;
                    contentColor3 = contentColor2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    modifier3 = modifier2;
                    elevation3 = elevation2;
                    contentPadding2 = paddingValues;
                    backgroundColor3 = backgroundColor2;
                    contentColor3 = contentColor2;
                } else {
                    modifier3 = modifier2;
                    elevation3 = elevation2;
                    contentPadding2 = paddingValues;
                    backgroundColor3 = backgroundColor2;
                    contentColor3 = contentColor2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1897058582, $dirty, -1, "androidx.compose.material.TopAppBar (AppBar.kt:274)");
            }
            $composer2 = $composer3;
            m1420AppBarHkEspTQ(backgroundColor3, contentColor3, elevation3, contentPadding2, RectangleShapeKt.getRectangleShape(), ZeroInsets, modifier3, function3, $composer2, (($dirty >> 3) & 14) | 221184 | (($dirty >> 3) & 112) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | (($dirty << 18) & 3670016) | (($dirty << 6) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            backgroundColor4 = backgroundColor3;
            contentColor4 = contentColor3;
            elevation4 = elevation3;
            contentPadding3 = contentPadding2;
            modifier4 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$5
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

                public final void invoke(Composer composer, int i7) {
                    AppBarKt.m1423TopAppBarHsRjFd4(modifier4, backgroundColor4, contentColor4, elevation4, contentPadding3, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x01f7  */
    /* renamed from: BottomAppBar-DanWW-k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1421BottomAppBarDanWWk(final androidx.compose.foundation.layout.WindowInsets r26, androidx.compose.ui.Modifier r27, long r28, long r30, androidx.compose.ui.graphics.Shape r32, float r33, androidx.compose.foundation.layout.PaddingValues r34, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AppBarKt.m1421BottomAppBarDanWWk(androidx.compose.foundation.layout.WindowInsets, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.graphics.Shape, float, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x01db  */
    /* renamed from: BottomAppBar-Y1yfwus, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1422BottomAppBarY1yfwus(androidx.compose.ui.Modifier r24, long r25, long r27, androidx.compose.ui.graphics.Shape r29, float r30, androidx.compose.foundation.layout.PaddingValues r31, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 573
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AppBarKt.m1422BottomAppBarY1yfwus(androidx.compose.ui.Modifier, long, long, androidx.compose.ui.graphics.Shape, float, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final float square(float x) {
        return x * x;
    }

    public static final float calculateCutoutCircleYIntercept(float cutoutRadius, float verticalOffset) {
        return -((float) Math.sqrt((cutoutRadius * cutoutRadius) - (verticalOffset * verticalOffset)));
    }

    public static final Pair<Float, Float> calculateRoundedEdgeIntercept(float controlPointX, float verticalOffset, float radius) {
        Float fValueOf;
        Float fValueOf2;
        Pair pair;
        Float fValueOf3;
        Float fValueOf4;
        float discriminant = verticalOffset * verticalOffset * radius * radius * (((controlPointX * controlPointX) + (verticalOffset * verticalOffset)) - (radius * radius));
        float divisor = (controlPointX * controlPointX) + (verticalOffset * verticalOffset);
        float bCoefficient = radius * radius * controlPointX;
        float xSolutionA = (bCoefficient - ((float) Math.sqrt(discriminant))) / divisor;
        float xSolutionB = (((float) Math.sqrt(discriminant)) + bCoefficient) / divisor;
        float ySolutionA = (float) Math.sqrt((radius * radius) - (xSolutionA * xSolutionA));
        float ySolutionB = (float) Math.sqrt((radius * radius) - (xSolutionB * xSolutionB));
        if (verticalOffset > 0.0f) {
            if (ySolutionA > ySolutionB) {
                fValueOf3 = Float.valueOf(xSolutionA);
                fValueOf4 = Float.valueOf(ySolutionA);
            } else {
                fValueOf3 = Float.valueOf(xSolutionB);
                fValueOf4 = Float.valueOf(ySolutionB);
            }
            pair = TuplesKt.to(fValueOf3, fValueOf4);
        } else {
            if (ySolutionA < ySolutionB) {
                fValueOf = Float.valueOf(xSolutionA);
                fValueOf2 = Float.valueOf(ySolutionA);
            } else {
                fValueOf = Float.valueOf(xSolutionB);
                fValueOf2 = Float.valueOf(ySolutionB);
            }
            pair = TuplesKt.to(fValueOf, fValueOf2);
        }
        float xSolution = ((Number) pair.component1()).floatValue();
        float ySolution = ((Number) pair.component2()).floatValue();
        float adjustedYSolution = xSolution < controlPointX ? -ySolution : ySolution;
        return TuplesKt.to(Float.valueOf(xSolution), Float.valueOf(adjustedYSolution));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: AppBar-HkEspTQ, reason: not valid java name */
    public static final void m1420AppBarHkEspTQ(final long backgroundColor, final long contentColor, final float elevation, final PaddingValues contentPadding, final Shape shape, final WindowInsets windowInsets, Modifier modifier, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        long j;
        float f;
        Shape shape2;
        Modifier modifier2;
        int i2;
        Composer $composer2;
        final Modifier modifier3;
        Composer $composer3 = $composer.startRestartGroup(-712505634);
        ComposerKt.sourceInformation($composer3, "C(AppBar)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3,6,7,5)726@31738L492,720@31571L659:AppBar.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(backgroundColor) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
            j = contentColor;
        } else if (($changed & 48) == 0) {
            j = contentColor;
            $dirty |= $composer3.changed(j) ? 32 : 16;
        } else {
            j = contentColor;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
            f = elevation;
        } else if (($changed & 384) == 0) {
            f = elevation;
            $dirty |= $composer3.changed(f) ? 256 : 128;
        } else {
            f = elevation;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(contentPadding) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
            shape2 = shape;
        } else if (($changed & 24576) == 0) {
            shape2 = shape;
            $dirty |= $composer3.changed(shape2) ? 16384 : 8192;
        } else {
            shape2 = shape;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            $dirty |= $composer3.changed(windowInsets) ? 131072 : 65536;
        }
        int i3 = i & 64;
        if (i3 != 0) {
            $dirty |= 1572864;
            modifier2 = modifier;
            i2 = 1572864;
        } else if (($changed & 1572864) == 0) {
            modifier2 = modifier;
            i2 = 1572864;
            $dirty |= $composer3.changed(modifier2) ? 1048576 : 524288;
        } else {
            modifier2 = modifier;
            i2 = 1572864;
        }
        if ((i & 128) != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 8388608 : 4194304;
        }
        int $dirty2 = $dirty;
        if ((4793491 & $dirty2) != 4793490 || !$composer3.getSkipping()) {
            if (i3 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-712505634, $dirty2, -1, "androidx.compose.material.AppBar (AppBar.kt:719)");
            }
            $composer2 = $composer3;
            long j2 = j;
            Modifier modifier4 = modifier2;
            SurfaceKt.m1676SurfaceFjzlyU(modifier4, shape2, backgroundColor, j2, null, f, ComposableLambdaKt.rememberComposableLambda(213273114, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
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
                    ComposerKt.sourceInformation($composer4, "C727@31813L6,727@31821L403,727@31748L476:AppBar.kt#jmzs0o");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(213273114, $changed2, -1, "androidx.compose.material.AppBar.<anonymous> (AppBar.kt:727)");
                        }
                        ProvidedValue<Float> providedValueProvides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium($composer4, 6)));
                        final WindowInsets windowInsets2 = windowInsets;
                        final PaddingValues paddingValues = contentPadding;
                        final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(600325466, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C728@31835L379:AppBar.kt#jmzs0o");
                                if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(600325466, $changed3, -1, "androidx.compose.material.AppBar.<anonymous>.<anonymous> (AppBar.kt:728)");
                                    }
                                    Modifier modifier$iv = SizeKt.m712height3ABfNKs(PaddingKt.padding(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), windowInsets2), paddingValues), AppBarKt.AppBarHeight);
                                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                    Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                                    Function3 content$iv = function32;
                                    ComposerKt.sourceInformationMarkerStart($composer5, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer5, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                                    int $changed$iv$iv = (432 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                    CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
                                    Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!($composer5.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer5.startReusableNode();
                                    if ($composer5.getInserting()) {
                                        $composer5.createNode(factory$iv$iv$iv);
                                    } else {
                                        $composer5.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer5);
                                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                                    }
                                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i4 = ($changed$iv$iv$iv >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                                    content$iv.invoke(RowScopeInstance.INSTANCE, $composer5, Integer.valueOf(((432 >> 6) & 112) | 6));
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    $composer5.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54), $composer4, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer2, (($dirty2 >> 18) & 14) | i2 | (($dirty2 >> 9) & 112) | (($dirty2 << 6) & 896) | (($dirty2 << 6) & 7168) | (458752 & ($dirty2 << 9)), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
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

                public final void invoke(Composer composer, int i4) {
                    AppBarKt.m1420AppBarHkEspTQ(backgroundColor, contentColor, elevation, contentPadding, shape, windowInsets, modifier3, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    static {
        Modifier.Companion companion = Modifier.INSTANCE;
        float arg0$iv = Dp.m6693constructorimpl(16);
        float other$iv = AppBarHorizontalPadding;
        TitleInsetWithoutIcon = SizeKt.m731width3ABfNKs(companion, Dp.m6693constructorimpl(arg0$iv - other$iv));
        Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
        float arg0$iv2 = Dp.m6693constructorimpl(72);
        float other$iv2 = AppBarHorizontalPadding;
        TitleIconModifier = SizeKt.m731width3ABfNKs(modifierFillMaxHeight$default, Dp.m6693constructorimpl(arg0$iv2 - other$iv2));
        BottomAppBarCutoutOffset = Dp.m6693constructorimpl(8);
        BottomAppBarRoundedEdgeRadius = Dp.m6693constructorimpl(4);
        ZeroInsets = WindowInsetsKt.m751WindowInsetsa9UjIt4$default(Dp.m6693constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null);
    }
}
